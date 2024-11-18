package com.example.domain.entities;

import com.example.domain.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Status status;
    private User user;
}
