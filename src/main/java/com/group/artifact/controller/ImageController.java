package com.group.artifact.controller;

import com.group.artifact.service.Image.ImageService;
import com.group.artifact.service.Recipe.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
public class ImageController {

    public RecipeService recipeService;
    public ImageService imageService;

    public ImageController(RecipeService recipeService, ImageService imageService) {
        this.recipeService = recipeService;
        this.imageService = imageService;
    }

    @GetMapping("/recipe/{id}/image")
    public String ChangeImage(@PathVariable String id, Model model) {
        if (id == null) return null;

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "image/form";
    }

    @PutMapping("/recipe/{id}/image")
    public String SaveOrUpdate(@PathVariable String id, @RequestParam("imagefile") MultipartFile file) {

        imageService.save(Long.valueOf(id), file);

        return "redirect:/recipe/" + id + "/showdetail";
    }
}
