package com.group.artifact.service.Recipe;

import com.group.artifact.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    //20190105
    Recipe findById(Long id);
    Long save(Recipe recipe);
    void delete(Long id);
}
