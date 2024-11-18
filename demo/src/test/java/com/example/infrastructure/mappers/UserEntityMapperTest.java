package com.example.infrastructure.mappers;

import com.example.domain.entities.User;
import com.example.domain.entities.enums.Role;
import com.example.infrastructure.persistence.UserEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityMapperTest {

    @Test
    void should_return_user_entity() {
        User user = new User(1L, "test", "test", Role.ADMIN);

        UserEntity userEntity = UserEntityMapper.toEntity(user);

        assertEquals(user.getId(), userEntity.getId());
        assertEquals(user.getName(), userEntity.getName());
        assertEquals(user.getPassword(), userEntity.getPassword());
        assertEquals(user.getRole().name(), userEntity.getRole());
    }

    @Test
    void should_return_user() {
        UserEntity entity = new UserEntity(1L, "test", "test", "ADMIN");

        User user = UserEntityMapper.toDomain(entity);

        assertEquals(entity.getId(), user.getId());
        assertEquals(entity.getName(), user.getName());
        assertEquals(entity.getPassword(), user.getPassword());
        assertEquals(entity.getRole(), user.getRole().name());
    }
}