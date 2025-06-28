package repozitories;



import com.example.models.Category;
import models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {

    // Найти все категории по ID пользователя
    List<Categories> findByUserId(Integer userId);

    // Найти категорию по имени и ID пользователя
    Categories findByCategoryNameAndUserId(String categoryName, Integer userId);

    // Проверить существование категории по имени и ID пользователя
    boolean existsByCategoryNameAndUserId(String categoryName, Integer userId);

    // Удалить все категории пользователя
    void deleteByUserId(Integer userId);
}