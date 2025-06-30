package repositories;

import models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
    List<Category> findByUserId(Integer userId);
    
    List<Category> findByCategoryNameContainingIgnoreCase(String categoryName);
    
    void deleteByUserId(Integer userId);
    
    long countByUserId(Integer userId);
}
