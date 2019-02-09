package com.group.artifact.repository;

import com.group.artifact.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
    
}
