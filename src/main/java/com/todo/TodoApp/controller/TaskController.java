package com.todo.TodoApp.controller;

import com.todo.TodoApp.dto.request.TaskRequest;
import com.todo.TodoApp.dto.response.TaskResponse;
import com.todo.TodoApp.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskResponse> getAllTasks() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable Long id) {
        return taskService.findOneTask(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest request) {
        return taskService.saveTask(request);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(@RequestBody TaskRequest request, @PathVariable Long id) {
        return taskService.updateById(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
