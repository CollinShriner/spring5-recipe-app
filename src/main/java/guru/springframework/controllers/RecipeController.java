package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(Model model, @PathVariable Long id) throws NotFoundException {
        model.addAttribute("recipe", recipeService.findById(id));

        return "recipe/show";
    }
}
