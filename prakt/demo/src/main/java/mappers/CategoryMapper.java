package mappers;

import com.example.dto.CategoryDto;
import com.example.dto.CategoryResponseDto;
import com.example.dto.CreateCategoryDto;
import com.example.models.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CreateCategoryDto dto) {
        Category category = new Category();
        category.setUserId(dto.getUserId());
        category.setCategoryName(dto.getCategoryName());
        return category;
    }

    public Category toEntity(CategoryDto dto) {
        Category category = new Category();
        category.setCategoryId(dto.getCategoryId());
        category.setUserId(dto.getUserId());
        category.setCategoryName(dto.getCategoryName());
        return category;
    }

    public CategoryDto toDto(Category entity) {
        CategoryDto dto = new CategoryDto();
        dto.setCategoryId(entity.getCategoryId());
        dto.setUserId(entity.getUserId());
        dto.setCategoryName(entity.getCategoryName());
        return dto;
    }

    public CategoryResponseDto toResponseDto(Category entity) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setCategoryId(entity.getCategoryId());
        dto.setUserId(entity.getUserId());
        dto.setCategoryName(entity.getCategoryName());
        // Для дат нужно добавить соответствующие поля в сущность Category
        // dto.setCreatedAt(entity.getCreatedAt());
        // dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
