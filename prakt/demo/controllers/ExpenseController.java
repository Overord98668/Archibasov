package controllers;

import models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import services.ExpenseService;

import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
@Validated
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Получить все расходы
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    // Получить расход по ID
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Integer id) {
        Optional<Expense> expense = expenseService.getExpenseById(id);
        return expense.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // Получить расходы по пользователю
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Expense>> getExpensesByUserId(@PathVariable Integer userId) {
        List<Expense> expenses = expenseService.getExpensesByUserId(userId);
        return ResponseEntity.ok(expenses);
    }

    // Получить расходы по категории
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Expense>> getExpensesByCategoryId(@PathVariable Integer categoryId) {
        List<Expense> expenses = expenseService.getExpensesByCategoryId(categoryId);
        return ResponseEntity.ok(expenses);
    }

    // Получить расходы по дате
    @GetMapping("/date/{date}")
    public ResponseEntity<List<Expense>> getExpensesByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Expense> expenses = expenseService.getExpensesByDate(date);
        return ResponseEntity.ok(expenses);
    }

    // Получить расходы за период
    @GetMapping("/period")
    public ResponseEntity<List<Expense>> getExpensesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<Expense> expenses = expenseService.getExpensesByDateRange(startDate, endDate);
        return ResponseEntity.ok(expenses);
    }

    // Получить расходы пользователя за период
    @GetMapping("/user/{userId}/period")
    public ResponseEntity<List<Expense>> getUserExpensesByDateRange(
            @PathVariable Integer userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<Expense> expenses = expenseService.getUserExpensesByDateRange(userId, startDate, endDate);
        return ResponseEntity.ok(expenses);
    }

    // Получить расходы по сумме (больше указанной)
    @GetMapping("/amount/greater/{amount}")
    public ResponseEntity<List<Expense>> getExpensesGreaterThanAmount(@PathVariable BigDecimal amount) {
        List<Expense> expenses = expenseService.getExpensesGreaterThanAmount(amount);
        return ResponseEntity.ok(expenses);
    }

    // Создать новый расход
    @PostMapping
    public ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense) {
        try {
            Expense savedExpense = expenseService.saveExpense(expense);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedExpense);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Обновить расход
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Integer id, @Valid @RequestBody Expense expense) {
        if (!expenseService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        expense.setId(id);
        Expense updatedExpense = expenseService.saveExpense(expense);
        return ResponseEntity.ok(updatedExpense);
    }

    // Частично обновить расход
    @PatchMapping("/{id}")
    public ResponseEntity<Expense> partialUpdateExpense(@PathVariable Integer id, @RequestBody Expense expenseUpdates) {
        Optional<Expense> existingExpense = expenseService.getExpenseById(id);
        if (existingExpense.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Expense expense = existingExpense.get();
        if (expenseUpdates.getAmount() != null) {
            expense.setAmount(expenseUpdates.getAmount());
        }
        if (expenseUpdates.getDate() != null) {
            expense.setDate(expenseUpdates.getDate());
        }
        if (expenseUpdates.getCategory() != null) {
            expense.setCategory(expenseUpdates.getCategory());
        }

        Expense updatedExpense = expenseService.saveExpense(expense);
        return ResponseEntity.ok(updatedExpense);
    }

    // Удалить расход
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Integer id) {
        if (!expenseService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }

    // Получить общую сумму расходов пользователя
    @GetMapping("/user/{userId}/total")
    public ResponseEntity<BigDecimal> getTotalExpensesByUserId(@PathVariable Integer userId) {
        BigDecimal total = expenseService.getTotalExpensesByUserId(userId);
        return ResponseEntity.ok(total);
    }

    // Получить общую сумму расходов по категории
    @GetMapping("/category/{categoryId}/total")
    public ResponseEntity<BigDecimal> getTotalExpensesByCategoryId(@PathVariable Integer categoryId) {
        BigDecimal total = expenseService.getTotalExpensesByCategoryId(categoryId);
        return ResponseEntity.ok(total);
    }

    // Получить общую сумму расходов за период
    @GetMapping("/period/total")
    public ResponseEntity<BigDecimal> getTotalExpensesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        BigDecimal total = expenseService.getTotalExpensesByDateRange(startDate, endDate);
        return ResponseEntity.ok(total);
    }

    // Получить количество расходов пользователя
    @GetMapping("/user/{userId}/count")
    public ResponseEntity<Long> getExpensesCountByUserId(@PathVariable Integer userId) {
        long count = expenseService.getExpensesCountByUserId(userId);
        return ResponseEntity.ok(count);
    }
}
