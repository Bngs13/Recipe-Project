package com.group.artifact.controller;

import com.group.artifact.command.IngredientCommand;
import com.group.artifact.command.UnitOfMeasureCommand;
import com.group.artifact.converter.IngredientCommandToIngredient;
import com.group.artifact.converter.IngredientToIngredientCommand;
import com.group.artifact.domain.Ingredient;
import com.group.artifact.service.Ingredient.IngredientService;
import com.group.artifact.service.Recipe.RecipeService;
import com.group.artifact.service.UnitOfMeasure.UOMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

//20190106
@Slf4j
@Controller
public class IngredientController {

    private final IngredientService ingredientService;
    private final IngredientToIngredientCommand convertToIngredientCommand;
    private final UOMService uomService;
    private final IngredientCommandToIngredient convertToIngredient;
    private final RecipeService recipeService;

    public IngredientController(IngredientService ingredientService, IngredientToIngredientCommand convertToIngredientCommand, UOMService uomService, IngredientCommandToIngredient convertToIngredient, RecipeService recipeService) {
        this.ingredientService = ingredientService;
        this.convertToIngredientCommand = convertToIngredientCommand;
        this.uomService = uomService;
        this.convertToIngredient = convertToIngredient;
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{recipeId}/ingredients")
    public String List(@PathVariable String recipeId, Model model) {

        if (recipeId.isEmpty() || recipeId == null) return null;

        Set<Ingredient> ingredients = ingredientService.getIngredientByRecipeId(Long.valueOf(recipeId));
        Set<IngredientCommand> ingredientCommand = new HashSet<>();
        for (Ingredient ingredient : ingredients) {
            ingredientCommand.add(convertToIngredientCommand.convert(ingredient));
        }

        model.addAttribute("ingredients", ingredientCommand);

        return "ingredient/list";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{id}/detail")
    public String Detail(@PathVariable String id, @PathVariable String recipeId, Model model) {
        Ingredient ingredient = ingredientService.findIngredientById(Long.valueOf(id), Long.valueOf(recipeId));
        IngredientCommand command = convertToIngredientCommand.convert(ingredient);
        model.addAttribute("ingredient", command);
        return "ingredient/detail";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{id}/update")
    public String Update(@PathVariable String recipeId, @PathVariable String id, Model model) {
        if (id.isEmpty() || id == null) return null;
        Ingredient ingredient = ingredientService.findIngredientById(Long.valueOf(id), Long.valueOf(recipeId));
        IngredientCommand ingredientCommand = convertToIngredientCommand.convert(ingredient);
        model.addAttribute("ingredient", ingredientCommand);
        model.addAttribute("uomList", uomService.findAll());
        return "ingredient/form";
    }

    @PostMapping("/recipe/{id}/ingredient")
    public String SaveOrUpdate(@PathVariable String id, @ModelAttribute IngredientCommand command) {
        if (id==null || command == null) return null;
        Long recipeId=Long.valueOf(id);
        command.setRecipeId(recipeId);
        Ingredient ingredient = convertToIngredient.convert(command);
        ingredientService.save(ingredient);

        return "redirect:/recipe/" + id + "/ingredient/" + command.getId().toString() + "/detail";
    }

    @GetMapping("recipe/{recipeId}/ingredient/new")
    public String Create(@PathVariable String recipeId, Model model) {
        if (recipeId == null) return null;

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setRecipeId(Long.valueOf(recipeId));
        model.addAttribute("ingredient", ingredientCommand);

        ingredientCommand.setUnitOfMeasure(new UnitOfMeasureCommand());

        model.addAttribute("uomList", uomService.findAll());

        return "ingredient/form";
    }
}
