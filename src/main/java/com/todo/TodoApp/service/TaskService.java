package com.todo.TodoApp.service;

import com.todo.TodoApp.dto.request.TaskRequest;
import com.todo.TodoApp.entity.Task;
import com.todo.TodoApp.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    @Transactional
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(Long id) {
        Task deletedTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(deletedTask);
    }

    @Transactional
    public List<Task> findAll() {
        return taskRepository.findAll();
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
