package com.example.application.ports;

import com.example.domain.entities.User;

public interface UserRepository {
    User save(User user);
}
