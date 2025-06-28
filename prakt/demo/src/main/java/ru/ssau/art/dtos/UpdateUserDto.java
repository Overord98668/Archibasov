package ru.ssau.art.dtos;

import jakarta.validation.constraints.Size;

public class UpdateUserDto {
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String userName;

    @Email(message = "Email should be valid")
    private String email;

    // Геттеры и сеттеры
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
