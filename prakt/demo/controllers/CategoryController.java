package controllers;

import models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import services.CategoryService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@Validated
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Получить все категории
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    // Получить категорию по ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
        Optional<Category> category = categoryService.getCategoryById(id);
        return category.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // Получить категории по пользователю
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Category>> getCategoriesByUserId(@PathVariable Integer userId) {
        List<Category> categories = categoryService.getCategoriesByUserId(userId);
        return ResponseEntity.ok(categories);
    }

    // Получить категории по имени
    @GetMapping("/search")
    public ResponseEntity<List<Category>> getCategoriesByName(@RequestParam String name) {
        List<Category> categories = categoryService.getCategoriesByName(name);
        return ResponseEntity.ok(categories);
    }

    // Создать новую категорию
    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
        try {
            Category savedCategory = categoryService.saveCategory(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Обновить категорию
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @Valid @RequestBody Category category) {
        if (!categoryService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        category.setCategoryId(id);
        Category updatedCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok(updatedCategory);
    }

    // Частично обновить категорию
    @PatchMapping("/{id}")
    public ResponseEntity<Category> partialUpdateCategory(@PathVariable Integer id, @RequestBody Category categoryUpdates) {
        Optional<Category> existingCategory = categoryService.getCategoryById(id);
        if (existingCategory.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Category category = existingCategory.get();
        if (categoryUpdates.getCategoryName() != null) {
            category.setCategoryName(categoryUpdates.getCategoryName());
        }
        if (categoryUpdates.getUserId() != null) {
            category.setUserId(categoryUpdates.getUserId());
        }

        Category updatedCategory = categoryService.saveCategory(category);
        return ResponseEntity.ok(updatedCategory);
    }

    // Удалить категорию
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        if (!categoryService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    // Удалить все категории пользователя
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteCategoriesByUserId(@PathVariable Integer userId) {
        categoryService.deleteCategoriesByUserId(userId);
        return ResponseEntity.noContent().build();
    }

    // Получить количество категорий пользователя
    @GetMapping("/user/{userId}/count")
    public ResponseEntity<Long> getCategoriesCountByUserId(@PathVariable Integer userId) {
        long count = categoryService.getCategoriesCountByUserId(userId);
        return ResponseEntity.ok(count);
    }
}
