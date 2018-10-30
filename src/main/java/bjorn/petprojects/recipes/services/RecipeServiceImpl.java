package bjorn.petprojects.recipes.services;

import bjorn.petprojects.recipes.domain.Recipe;
import bjorn.petprojects.recipes.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> allRecipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(allRecipes::add);
        return allRecipes;
    }

    @Override
    public Recipe findById(Long id){
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe with id "+id+" not found!");
        }
        return recipeOptional.get();
    }
}
