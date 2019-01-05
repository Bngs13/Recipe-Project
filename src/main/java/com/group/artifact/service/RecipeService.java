package com.group.artifact.service;

import com.group.artifact.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long id); //20190105
}
