package com.todo.TodoApp.service;

import com.todo.TodoApp.custom_exceptions.TaskNotFoundException;
import com.todo.TodoApp.dto.request.TaskRequest;
import com.todo.TodoApp.dto.response.TaskResponse;
import com.todo.TodoApp.entity.Task;
import com.todo.TodoApp.mapper.TaskMapper;
import com.todo.TodoApp.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

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
    public TaskResponse updateById(Long id, TaskRequest request) {
        Task updateTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        updateTask.setTaskName(request.getTaskName());
        updateTask.setDateToComplete(request.getDateToComplete());

        Task savedTask = taskRepository.save(updateTask);

        return taskMapper.toResponse(savedTask);
    }

    @Transactional
    public TaskResponse findOneTask(Long id) {
        Task foundOne = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        return taskMapper.toResponse(foundOne);
    }
}
