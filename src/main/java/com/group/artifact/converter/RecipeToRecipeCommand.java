package com.group.artifact.converter;

import com.group.artifact.command.RecipeCommand;
import com.group.artifact.domain.Category;
import com.group.artifact.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand>{

    private final CategoryToCategoryCommand categoryConverter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NotesToNotesCommand notesConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConveter, IngredientToIngredientCommand ingredientConverter,
                                 NotesToNotesCommand notesConverter) {
        this.categoryConverter = categoryConveter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        if (source == null) {
            return null;
        }

        final RecipeCommand command = new RecipeCommand();
        command.setId(source.getId());
        command.setCookTime(source.getCookTime());
        command.setPrepTime(source.getPrepTime());
        command.setDescription(source.getDescription());
        command.setDifficulty(source.getDifficulity());
        command.setDirections(source.getDirection());
        command.setServings(source.getServing());
        command.setSource(source.getSource());
        command.setUrl(source.getUrl());
        command.setNotes(notesConverter.convert(source.getNotes()));

        if (source.getCategory() != null && source.getCategory().size() > 0){
            source.getCategory()
                    .forEach((Category category) -> command.getCategories().add(categoryConverter.convert(category)));
        }

        if (source.getIngredient() != null && source.getIngredient().size() > 0){
            source.getIngredient()
                    .forEach(ingredient -> command.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        return command;
    }
}
