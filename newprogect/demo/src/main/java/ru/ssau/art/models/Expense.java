package ru.ssau.art.models;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ex_id")
    private Integer id;

    @Column(name = "fk_user_id", nullable = false)
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_category_id", referencedColumnName = "category_id")
    private Category category;  // Изменено с Category на Categories

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "amount_date", nullable = false)
    private LocalDate date;

    // Конструкторы
    public Expense() {
    }

    public Expense(Integer userId, Category category, BigDecimal amount, LocalDate date) {
        this.userId = userId;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    // Геттеры и сеттеры
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Category getCategory() {  // Изменено возвращаемый тип
        return category;
    }

    public void setCategory(Category category) {  // Изменено тип параметра
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(id, expense.id) &&
                Objects.equals(userId, expense.userId) &&
                Objects.equals(category, expense.category) &&
                Objects.equals(amount, expense.amount) &&
                Objects.equals(date, expense.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, category, amount, date);
    }

    // toString
    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", userId=" + userId +
                ", category=" + (category != null ? category.getCategoryId() : null) +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
