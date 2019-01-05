package com.group.artifact.service;

import com.group.artifact.domain.Recipe;
import com.group.artifact.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public Recipe findById(Long id) {
        if (id == 0) return null;

        Optional<Recipe> recipe = recipeRepository.findById(id);

        if (!recipe.isPresent())
            throw new RuntimeException("Recipe Not Found!");

        return recipe.get();
    }
}
