package ru.ssau.art.mappers;



import ru.ssau.art.models.Category;
import org.springframework.stereotype.Component;
import ru.ssau.art.dtos.CategoryDto;
import ru.ssau.art.dtos.CategoryResponseDto;
import ru.ssau.art.dtos.CreateCategoryDto;

@Component
public class CategoryMapper {

    public Category toEntity(CreateCategoryDto dto) {
        Category Category = new Category();
        Category.setCategoryName(dto.getCategoryName());
        return Category;
    }

    public Category toEntity(CategoryDto dto) {
        Category Category = new Category();
        Category.setCategoryId(dto.getCategoryId());
        Category.setCategoryName(dto.getCategoryName());
        return Category;
    }

    public CategoryDto toDto(Category entity) {
        CategoryDto dto = new CategoryDto();
        dto.setCategoryId(entity.getCategoryId());
        dto.setCategoryName(entity.getCategoryName());
        return dto;
    }

    public CategoryResponseDto toResponseDto(Category entity) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setCategoryId(entity.getCategoryId());
        dto.setCategoryName(entity.getCategoryName());
        // Для дат нужно добавить соответствующие поля в сущность Category
        // dto.setCreatedAt(entity.getCreatedAt());
        // dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
