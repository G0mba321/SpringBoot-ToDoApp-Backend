package com.todo.TodoApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    private String taskName;

    private LocalDateTime dateToComplete;

    public Task(String taskName, LocalDateTime dateToComplete) {
        this.taskName = taskName;
        this.dateToComplete = dateToComplete;
    }
}
