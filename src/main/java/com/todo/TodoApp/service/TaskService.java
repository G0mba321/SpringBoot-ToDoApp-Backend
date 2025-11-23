package com.todo.TodoApp.service;

import com.todo.TodoApp.custom_exceptions.TaskNotFoundException;
import com.todo.TodoApp.dto.request.TaskRequest;
import com.todo.TodoApp.dto.response.TaskResponse;
import com.todo.TodoApp.entity.Task;
import com.todo.TodoApp.mapper.TaskMapper;
import com.todo.TodoApp.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    //+
    @Transactional
    public TaskResponse saveTask(TaskRequest request) {
        Task taskEntity = taskMapper.toEntity(request);
        Task saved = taskRepository.save(taskEntity);

        return taskMapper.toResponse(saved);
    }

    @Transactional
    public void deleteTask(Long id) {
        Task deletedTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        taskRepository.delete(deletedTask);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<TaskResponse> findAll() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public Task updateById(Long id, TaskRequest request) {
        Task updateTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        updateTask.setTaskName(request.taskName);
        updateTask.setDateToComplete(request.dateToComplete);

        return taskRepository.save(updateTask);
    }
}
