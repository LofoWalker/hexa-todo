package com.example.domain.services;

import com.example.domain.entities.User;

public class UserService {

    public UserService() {}

    public User create(User user) {
        return new User(null, user.getName(), user.getPassword(), user.getRole());
    }
}
