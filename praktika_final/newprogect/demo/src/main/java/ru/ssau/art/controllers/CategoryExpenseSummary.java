package ru.ssau.art.controllers;

import java.math.BigDecimal;

public class CategoryExpenseSummary {
    private Integer categoryId;
    private String categoryName;
    private BigDecimal totalAmount;
    private Long expenseCount;

    // Конструкторы
    public CategoryExpenseSummary() {}

    public CategoryExpenseSummary(Integer categoryId, String categoryName, BigDecimal totalAmount, Long expenseCount) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.totalAmount = totalAmount;
        this.expenseCount = expenseCount;
    }

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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getExpenseCount() {
        return expenseCount;
    }

    public void setExpenseCount(Long expenseCount) {
        this.expenseCount = expenseCount;
    }

    @Override
    public String toString() {
        return "CategoryExpenseSummary{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", totalAmount=" + totalAmount +
                ", expenseCount=" + expenseCount +
                '}';
    }
}

