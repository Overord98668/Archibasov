package ru.ssau.art.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ExpenseDTO {
    private Integer userId;
    private Integer categoryId;
    private BigDecimal amount;
    private LocalDate amountDate;


    public Integer getUserId() {
        return userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getAmountDate() {
        return amountDate;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setAmountDate(LocalDate amountDate) {
        this.amountDate = amountDate;
    }
}
