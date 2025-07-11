package ru.ssau.art.repositories;

import ru.ssau.art.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {


    List<Category> findByCategoryNameContainingIgnoreCase(String categoryName);


}
