package com.group.artifact.service.Recipe;

import com.group.artifact.domain.Recipe;
import com.group.artifact.exception.NotFoundExceptionCustom;
import com.group.artifact.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j //20190101
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Here is inside of RecipeServiceImpl");//20190101
        Set<Recipe> recipeSet = new HashSet<>();
        //20181229, Converting to optional or set from iterable
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }

    //20190105
    @Override
    @Transactional//doing a conversion outside the scope. So if we hit any lazy loaded
    //properties it would go kaboom. So we are expanding out the transactional scope to
    //this method and then we just returned back a converted object so we take in and we're reusing that method
    public Recipe findById(Long id) {
        if (id == 0) return null;

        Optional<Recipe> recipe = recipeRepository.findById(id);

        if (!recipe.isPresent())
            //20190209, Error handling is added
            //throw new RuntimeException("Recipe Not Found!");
            throw new NotFoundExceptionCustom("Recipe Not Found!");
        return recipe.get();
    }

    //20190105
    @Override
    @Transactional
    public Long save(Recipe recipe) {
        if (recipe == null) return 0l;

        Recipe saveRecipe = recipeRepository.save(recipe);
        log.debug("Saved RecipeId:" + saveRecipe.getId());
        return saveRecipe.getId();
    }

    //20190105
    @Override
    public void delete(Long id) {
        if (id == 0) return;
        recipeRepository.deleteById(id);
    }

}
