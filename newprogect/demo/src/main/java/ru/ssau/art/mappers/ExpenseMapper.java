package ru.ssau.art.mappers;


import ru.ssau.art.models.Expense;
import org.springframework.stereotype.Component;
import ru.ssau.art.dtos.CreateExpenseDto;
import ru.ssau.art.dtos.ExpenseDto;
import ru.ssau.art.dtos.ExpenseResponseDto;
import ru.ssau.art.dtos.ExpenseStatsDto;

import java.math.BigDecimal;

@Component
public class ExpenseMapper {

    public Expense toEntity(CreateExpenseDto dto) {
        Expense expense = new Expense();
        expense.setUserId(dto.getUserId());
        expense.setAmount(dto.getAmount());
        expense.setDate(dto.getDate());
        // category устанавливается отдельно через setCategory
        return expense;
    }

    public Expense toEntity(ExpenseDto dto) {
        Expense expense = new Expense();
        expense.setId(dto.getId());
        expense.setUserId(dto.getUserId());
        expense.setAmount(dto.getAmount());
        expense.setDate(dto.getDate());
        // category устанавливается отдельно через setCategory
        return expense;
    }

    public ExpenseDto toDto(Expense entity) {
        ExpenseDto dto = new ExpenseDto();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setCategoryId(entity.getCategory().getCategoryId());
        dto.setAmount(entity.getAmount());
        dto.setDate(entity.getDate());
        return dto;
    }

    public ExpenseResponseDto toResponseDto(Expense entity) {
        ExpenseResponseDto dto = new ExpenseResponseDto();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setCategoryId(entity.getCategory().getCategoryId());
        dto.setCategoryName(entity.getCategory().getCategoryName());
        dto.setAmount(entity.getAmount());
        dto.setDate(entity.getDate());
        // createdAt и updatedAt должны быть в сущности Expense
        // dto.setCreatedAt(entity.getCreatedAt());
        // dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public ExpenseStatsDto toStatsDto(Object[] result) {
        ExpenseStatsDto dto = new ExpenseStatsDto();
        dto.setCategoryId((Integer) result[0]);
        dto.setTotalAmount((BigDecimal) result[1]);
        return dto;
    }
}
