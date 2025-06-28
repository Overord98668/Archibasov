package models;

import jakarta.persistence.*;


import java.util.Objects;

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "fk_user_id", nullable = false)
    private Integer userId;

    @Column(name = "category_name", nullable = false, columnDefinition = "text")
    private String categoryName;

    // Конструкторы
    public void Category() {
    }

    public void Category(Integer userId, String categoryName) {
        this.userId = userId;
        this.categoryName = categoryName;
    }

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

    // equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories category = (Categories) o;
        return Objects.equals(categoryId, category.categoryId) &&
                Objects.equals(userId, category.userId) &&
                Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, userId, categoryName);
    }

    // toString
    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", userId=" + userId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}