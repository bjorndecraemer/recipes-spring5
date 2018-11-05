package bjorn.petprojects.recipes.services;

import bjorn.petprojects.recipes.commands.RecipeCommand;
import bjorn.petprojects.recipes.domain.Recipe;

import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
