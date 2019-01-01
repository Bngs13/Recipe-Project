package com.group.artifact.controller;

import com.group.artifact.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j //20190101
@Controller
public class IndexController {

    private final RecipeService recipeService;


    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String GetIndexPage(Model model) {

        log.debug("Getting Index page"); //20190101
        model.addAttribute("recipes",recipeService.getRecipes());

        return "index";
    }
}
