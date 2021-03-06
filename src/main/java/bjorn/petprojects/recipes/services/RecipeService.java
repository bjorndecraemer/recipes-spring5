package bjorn.petprojects.recipes.services;

import bjorn.petprojects.recipes.commands.RecipeCommand;
import bjorn.petprojects.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long l);
}
