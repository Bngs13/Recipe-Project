package com.group.artifact.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Data //20190101
@EqualsAndHashCode(exclude = {"recipe"})//20190101, adding in one side of relationship is enough
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer serving;
    private String source;
    private String url;
    @Lob
    private String direction;
    //20181225, EnumType.ORDINAL is default, use it when the order doesn't matter, shown like number in db
    //EnumType.STRING enums are linked to the order, but you can't change them, just adding is possible, shown like string in db
    @Enumerated(value = EnumType.STRING)
    private Difficulity difficulity;
    @OneToOne(cascade = CascadeType.ALL)
    private Note notes;
    @Lob
    private Byte[] image;
    //20181225, each object of Ingredient is going to be a property called recipe
    //recipe is the target property on the Ingredient class. So if we look over at Ingredient,
    //I have a property called recipe and so that defines that direction.
    //20181225, Bidirectional
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredient;

    @ManyToMany
    //20181227, name is for table name, others are column names
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> category;

    public Recipe() {
        //20181228, you can initialize them into related property's getter method rather than constructor
        this.ingredient = new HashSet<>();
        this.category = new HashSet<>();
    }

    //20181229
    public Recipe addIngredient(Ingredient ingredient) {
        if (!Optional.of(ingredient).isPresent()) return null;
        ingredient.setRecipe(this);
        this.ingredient.add(ingredient);
        return this;
    }
}

