package ru.ssau.art.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateCategoryDto {
    @NotNull(message = "User ID cannot be null")
    private Integer userId;

    @NotBlank(message = "Category name cannot be blank")
    @Size(max = 255, message = "Category name must be less than 255 characters")
    private String categoryName;

    // Геттеры и сеттеры
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}