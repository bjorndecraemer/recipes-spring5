package bjorn.petprojects.recipes.controllers;

import bjorn.petprojects.recipes.commands.RecipeCommand;
import bjorn.petprojects.recipes.exceptions.NotFoundException;
import bjorn.petprojects.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jt on 6/19/17.
 */
@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));

        return "recipe/show";
    }

    @GetMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @GetMapping("/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeform";
    }
    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/"+savedCommand.getId()+"/show";
    }

    @GetMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id){
        log.debug("Deleting recipe with id : "+id);
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception exception){
        return GenerateModelAndViewForExceptions(exception, "Handling not found exception", "404error");
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormatException(Exception exception){
        return GenerateModelAndViewForExceptions(exception, "Handling NumberFormatException", "400error");
    }

    /*
     *Helper method to Generate a @ModelAndView for exceptions
     */
    private ModelAndView GenerateModelAndViewForExceptions(Exception exception, String s, String s2) {
        log.error(s);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(s2);
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }
}
