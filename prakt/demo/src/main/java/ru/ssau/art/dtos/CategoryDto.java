package ru.ssau.art.dtos;

import org.antlr.v4.runtime.misc.NotNull;

public class CategoryDto {
    private Integer categoryId;

    @NotNull(message = "User ID cannot be null")
    private Integer userId;

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