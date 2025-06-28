package repozitories;

import com.example.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    // Найти все расходы пользователя
    List<Expense> findByUserId(Integer userId);

    // Найти расходы пользователя за определенный период
    List<Expense> findByUserIdAndDateBetween(Integer userId, LocalDate startDate, LocalDate endDate);

    // Найти расходы по категории
    List<Expense> findByUserIdAndCategory_CategoryId(Integer userId, Integer categoryId);

    // Сумма расходов пользователя за период
    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.userId = :userId AND e.date BETWEEN :startDate AND :endDate")
    BigDecimal sumAmountByUserIdAndDateBetween(
            @Param("userId") Integer userId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    // Сумма расходов по категориям за период
    @Query("SELECT e.category.categoryId, SUM(e.amount) " +
            "FROM Expense e " +
            "WHERE e.userId = :userId AND e.date BETWEEN :startDate AND :endDate " +
            "GROUP BY e.category.categoryId")
    List<Object[]> sumAmountByCategoryAndDateBetween(
            @Param("userId") Integer userId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);

    // Удалить расходы пользователя
    void deleteByUserId(Integer userId);
}