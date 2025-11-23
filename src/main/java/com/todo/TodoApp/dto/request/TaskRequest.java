package com.todo.TodoApp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class TaskRequest {

     @NotBlank(message = "Name of task cannot be blank")
     public String taskName;

     @NotNull(message = "cannot be without time")
     public LocalDateTime dateToComplete;
}
