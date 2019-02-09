package com.group.artifact.service.Ingredient;

import com.group.artifact.domain.Ingredient;

import java.util.Set;

public interface IngredientService {
    Set<Ingredient> getIngredientByRecipeId(Long recipeId);

    Ingredient findIngredientById(Long id, Long recipeId);

    void save(Ingredient ingredient);
}
