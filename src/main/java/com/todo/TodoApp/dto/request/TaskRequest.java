package com.todo.TodoApp.dto.request;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class TaskRequest {
     public String taskName;
     public LocalDateTime dateToComplete;
}
