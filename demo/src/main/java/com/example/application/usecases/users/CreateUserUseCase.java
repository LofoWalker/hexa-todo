package com.example.application.usecases.users;

import com.example.application.ports.UserRepository;
import com.example.domain.entities.User;
import com.example.domain.services.UserService;

public class CreateUserUseCase {

    private final UserRepository userRepository;
    private final UserService userService;

    public CreateUserUseCase(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public User execute(User userToSave) {
        User user = userService.create(userToSave);
        return userRepository.save(user);
    }
}
