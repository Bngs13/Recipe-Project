package com.group.artifact.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data //20190101
@EqualsAndHashCode(exclude = {"recipe"})//20190101
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "category")
    private Set<Recipe> recipe;

    //20190101, because @EqualsAndHashCode is added
    //public Set<Recipe> getRecipes() {
    //   return recipe;
    //}

    // public void setRecipes(Set<Recipe> recipes) {
    //    this.recipe = recipes;
    // }
}
