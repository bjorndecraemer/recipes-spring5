package bjorn.petprojects.repositories;

import bjorn.petprojects.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
