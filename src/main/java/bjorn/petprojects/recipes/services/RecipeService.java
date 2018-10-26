package bjorn.petprojects.recipes.services;

import bjorn.petprojects.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
