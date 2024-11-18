package com.example.infrastructure.mappers;

import com.example.domain.entities.User;
import com.example.domain.entities.enums.Role;
import com.example.infrastructure.persistence.UserEntity;

public class UserEntityMapper {

    public static UserEntity toEntity(User user) {
        return new UserEntity(user.getId(), user.getName(), user.getPassword(), user.getRole().name());
    }

    public static User toDomain(UserEntity entity) {
        return new User(entity.getId(), entity.getName(), entity.getPassword(), Role.valueOf(entity.getRole()));
    }
}
