package ru.ssau.art.services;

import ru.ssau.art.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ssau.art.repositories.ExpenseRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(Integer id) {
        return expenseRepository.findById(id);
    }

    public List<Expense> getExpensesByUserId(Integer userId) {
        return expenseRepository.findByUserId(userId);
    }

    public List<Expense> getExpensesByCategoryId(Integer categoryId) {
        return expenseRepository.findByCategoryCategoryId(categoryId);
    }

    public List<Expense> getExpensesByDate(LocalDate date) {
        return expenseRepository.findByDate(date);
    }

    public List<Expense> getExpensesByDateRange(LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findByDateBetween(startDate, endDate);
    }

    public List<Expense> getUserExpensesByDateRange(Integer userId, LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findByUserIdAndDateBetween(userId, startDate, endDate);
    }

    public List<Expense> getExpensesGreaterThanAmount(BigDecimal amount) {
        return expenseRepository.findByAmountGreaterThan(amount);
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Integer id) {
        expenseRepository.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return expenseRepository.existsById(id);
    }

    public BigDecimal getTotalExpensesByUserId(Integer userId) {
        return expenseRepository.sumAmountByUserId(userId);
    }

    public BigDecimal getTotalExpensesByCategoryId(Integer categoryId) {
        return expenseRepository.sumAmountByCategoryCategoryId(categoryId);
    }

    public BigDecimal getTotalExpensesByDateRange(LocalDate startDate, LocalDate endDate) {
        return expenseRepository.sumAmountByDateBetween(startDate, endDate);
    }

    public long getExpensesCountByUserId(Integer userId) {
        return expenseRepository.countByUserId(userId);
    }
}
