package bjorn.petprojects.repositories;

import bjorn.petprojects.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
