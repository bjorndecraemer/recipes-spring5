package bjorn.petprojects.recipes.repositories;

import bjorn.petprojects.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
