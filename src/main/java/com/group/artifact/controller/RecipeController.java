package com.group.artifact.controller;

import com.group.artifact.command.RecipeCommand;
import com.group.artifact.converter.RecipeCommandToRecipe;
import com.group.artifact.converter.RecipeToRecipeCommand;
import com.group.artifact.domain.Recipe;
import com.group.artifact.service.Recipe.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//20190105
@Slf4j
@Controller
public class RecipeController {
    private final RecipeService recipeService;
    private final RecipeCommandToRecipe convertToRecipe;
    private final RecipeToRecipeCommand convertToRecipeCommand;

    public RecipeController(RecipeService recipeService, RecipeCommandToRecipe convertToRecipe, RecipeToRecipeCommand convertToRecipeCommand) {
        this.recipeService = recipeService;
        this.convertToRecipe = convertToRecipe;
        this.convertToRecipeCommand = convertToRecipeCommand;
    }

    @GetMapping
    @RequestMapping("/recipe/showdetail/{id}")
    public String ShowDetail(@PathVariable String id, Model model) {
        if (id.isEmpty()) return null;
        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        return "recipe/showdetail";
    }

    @GetMapping
    @RequestMapping("/recipe/create/")
    public String Create(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/create";
    }

    @PostMapping("recipe") //20190105, new way of @RequestMapping(name="recipe",method = RequestMethod.POST)
    //@RequestMapping(name = "recipe")
    public String SaveOrUpdate(@ModelAttribute RecipeCommand command) {
        Recipe recipe = convertToRecipe.convert(command);
        Long id = recipeService.save(recipe);
        if (id == 0) return "recipe/create";
        return "redirect:/recipe/showdetail/" + id.toString();
    }

    @GetMapping
    @RequestMapping("recipe/{id}/update")
    public String Update(@PathVariable String id, Model model) {
        if (id == null || id.isEmpty() || model == null) return null;
        Recipe recipe = recipeService.findById(Long.valueOf(id));
        RecipeCommand command = convertToRecipeCommand.convert(recipe);
        model.addAttribute("recipe", command);
        return "recipe/create";
    }

    @GetMapping //without this annotation, the method is supplied by all http method
    @RequestMapping("recipe/{id}/delete")
    public String Delete(@PathVariable String id) {
        log.debug("Deleted id" + id);
        recipeService.delete(Long.valueOf(id));
        return "redirect:/";

    }
}
