package com.todo.TodoApp.controller;

import com.todo.TodoApp.dto.request.TaskRequest;
import com.todo.TodoApp.dto.response.TaskResponse;
import com.todo.TodoApp.entity.Task;
import com.todo.TodoApp.mapper.TaskMapper;
import com.todo.TodoApp.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;


    @GetMapping
    public List<TaskResponse> allTasks() {
        return taskService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest request) {
        return taskService.saveTask(request);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(@RequestBody TaskRequest request, @PathVariable Long id) {
        Task updateTask = taskService.updateById(id, request);

        return taskMapper.toResponse(updateTask);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void removeTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }


}
