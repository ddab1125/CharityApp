package pl.coderslab.charity.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.category.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryById(long id);
}
