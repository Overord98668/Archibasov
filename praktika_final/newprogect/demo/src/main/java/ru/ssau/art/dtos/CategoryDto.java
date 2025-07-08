package ru.ssau.art.dtos;

import jakarta.validation.constraints.*;


public class CategoryDto {
    private Integer categoryId;



    @NotBlank(message = "Category name cannot be blank")
    @Size(max = 255, message = "Category name must be less than 255 characters")
    private String categoryName;

    // Геттеры и сеттеры
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }



    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}