package ru.ssau.art.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateCategoryDto {
    @NotBlank(message = "Category name cannot be blank")
    @Size(max = 255, message = "Category name must be less than 255 characters")
    private String categoryName;

    // Геттеры и сеттеры
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}