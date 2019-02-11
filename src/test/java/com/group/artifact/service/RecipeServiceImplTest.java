package com.group.artifact.service;

import com.group.artifact.domain.Recipe;
import com.group.artifact.repository.RecipeRepository;
import com.group.artifact.service.Recipe.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

//20190103, Mockito Mocks
public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock//Fake implementation for a class
     RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this); //initialization of mocks
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

       //*recipeService.getRecipes() is called then return recipesData
        when(recipeService.getRecipes()).thenReturn(recipesData);

        Set<Recipe> recipeSet = recipeService.getRecipes();
        //Mockito gives us empty set, so 0 is ok but for 1 it gives error without *
        assertEquals(recipeSet.size(), 1);
        //sure that findAll() or recipeRepository is called only once
        verify(recipeRepository,times(1)).findAll();
    }
}