package com.todo.TodoApp.exceptions;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Cannot find task " + id);
    }
}
