package com.group.artifact.converter;

import com.group.artifact.command.IngredientCommand;
import com.group.artifact.domain.Ingredient;
import com.group.artifact.domain.Recipe;
import com.group.artifact.service.Recipe.RecipeService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;
    private final RecipeService recipeService;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter, RecipeService recipeService) {
        this.uomConverter = uomConverter;
        this.recipeService = recipeService;
    }

    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) return null;

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        if (source.getUnitOfMeasure() != null)
            ingredient.setUom(uomConverter.convert(source.getUnitOfMeasure()));
        if (source.getRecipeId() != null) {
            Recipe recipe = recipeService.findById(source.getRecipeId());
            if (recipe != null) {
                ingredient.setRecipe(recipe);
                recipe.addIngredient(ingredient);
            }
        }
        return ingredient;
    }
}
