package com.todo.TodoApp.controller;

import com.todo.TodoApp.dto.request.TaskRequest;
import com.todo.TodoApp.dto.response.TaskResponse;
import com.todo.TodoApp.entity.Task;
import com.todo.TodoApp.mapper.TaskMapper;
import com.todo.TodoApp.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;


    @GetMapping("/tasks")
    public List<TaskResponse> allTasks() {
        return taskMapper.toResponseList(taskService.findAll());
    }

    @PostMapping("/tasks/createTask")
    public TaskResponse createTask(@RequestBody TaskRequest request) {
        Task entity = taskMapper.toEntity(request);
        Task saved = taskService.saveTask(entity);

        return taskMapper.toResponse(saved);
    }

    @PutMapping("/task/update/{id}")
    public TaskResponse updateTask(@RequestBody TaskRequest request, @PathVariable Long id) {
        Task updateTask = taskService.updateById(id, request);

        return taskMapper.toResponse(updateTask);
    }



}
