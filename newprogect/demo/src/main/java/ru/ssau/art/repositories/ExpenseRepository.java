package ru.ssau.art.repositories;

import ru.ssau.art.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    
    List<Expense> findByUserId(Integer userId);
    
    List<Expense> findByCategoryCategoryId(Integer categoryId);
    
    List<Expense> findByDate(LocalDate date);
    
    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
    
    List<Expense> findByUserIdAndDateBetween(Integer userId, LocalDate startDate, LocalDate endDate);
    
    List<Expense> findByAmountGreaterThan(BigDecimal amount);
    
    long countByUserId(Integer userId);
    
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.userId = :userId")
    BigDecimal sumAmountByUserId(@Param("userId") Integer userId);
    
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.category.categoryId = :categoryId")
    BigDecimal sumAmountByCategoryCategoryId(@Param("categoryId") Integer categoryId);
    
    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.date BETWEEN :startDate AND :endDate")
    BigDecimal sumAmountByDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT e.category.id, e.category.categoryName, COALESCE(SUM(e.amount), 0) as totalAmount, COUNT(e) as expenseCount " +
            "FROM Expense e WHERE e.userId = :userId GROUP BY e.category.id, e.category.categoryName")
    List<Object[]> getExpensesSummaryByUserIdGroupedByCategory(@Param("userId") Integer userId);



}
