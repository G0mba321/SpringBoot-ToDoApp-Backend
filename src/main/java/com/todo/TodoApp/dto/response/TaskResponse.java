package com.todo.TodoApp.dto.response;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class TaskResponse {
    Long id;
    String taskName;
    LocalDateTime dateToComplete;

}
