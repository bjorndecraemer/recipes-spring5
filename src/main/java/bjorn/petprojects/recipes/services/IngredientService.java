package bjorn.petprojects.recipes.services;

import bjorn.petprojects.recipes.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long id);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteIngredientByRecipeIdAndIngredientId(Long recipeId, Long id);
}
