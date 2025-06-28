package mappers;

import com.example.dto.*;
import com.example.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserDto dto) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        return user;
    }

    public User toEntity(RegisterUserDto dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        // Пароль должен быть захеширован перед сохранением
        return user;
    }

    public UserDto toDto(User entity) {
        UserDto dto = new UserDto();
        dto.setUserId(entity.getUserId());
        dto.setUserName(entity.getUserName());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public UserResponseDto toResponseDto(User entity) {
        UserResponseDto dto = new UserResponseDto();
        dto.setUserId(entity.getUserId());
        dto.setUserName(entity.getUserName());
        dto.setEmail(entity.getEmail());
        // createdAt и updatedAt должны быть в сущности User
        // dto.setCreatedAt(entity.getCreatedAt());
        // dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public void updateEntityFromDto(UpdateUserDto dto, User entity) {
        if (dto.getUserName() != null) {
            entity.setUserName(dto.getUserName());
        }
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }
    }
}
