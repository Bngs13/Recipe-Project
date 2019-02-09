package com.group.artifact.service.Ingredient;

import com.group.artifact.domain.Ingredient;
import com.group.artifact.domain.Recipe;
import com.group.artifact.repository.IngredientRepository;
import com.group.artifact.service.Recipe.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final RecipeService recipeService;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, RecipeService recipeService) {
        this.ingredientRepository = ingredientRepository;
        this.recipeService = recipeService;
    }

    @Override
    public Set<Ingredient> getIngredientByRecipeId(Long recipeId) {
        if (recipeId == 0) return null;
        try {
            Recipe recipe = recipeService.findById(recipeId);
            Optional optionalRecipe = Optional.of(recipe);
            Set<Ingredient> ingredients = new HashSet<>();

            if (optionalRecipe.isPresent())
                ingredients = recipe.getIngredient();

            return ingredients;
        }
        catch (Exception e) {
            return  null;
        }
        }

    //20190107
    //TODO: Check recipe and uom when ingredients update
    @Override
    public Ingredient findIngredientById(Long id, Long recipeId) {
       /* Recipe recipe = recipeService.findById(recipeId);
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        if (!recipeOptional.isPresent()) {
            log.error("recipe id not found. Id: " + recipeId);
        }

        Optional<Ingredient> OptionalIngredient = recipe.getIngredient().stream()
                .filter(ingredient -> ingredient.getId().equals(id)).findFirst();

        if (!OptionalIngredient.isPresent()) {
            //todo impl error handling
            log.error("Ingredient id not found: " + id);
        }
        return OptionalIngredient.get();
*/
        if (id == 0) return null;
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (!ingredient.isPresent()) return null;
        return ingredient.get();
    }

    @Override
    @Transactional
    public void save(Ingredient ingredient) {
        if (ingredient == null) return;
        ingredientRepository.save(ingredient);
    }

}
