package com.todo.TodoApp.mapper;

import com.todo.TodoApp.dto.request.TaskRequest;
import com.todo.TodoApp.dto.response.TaskResponse;
import com.todo.TodoApp.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {

    Task toEntity(TaskRequest request);

    TaskResponse toResponse(Task entity);

    List<TaskResponse> toResponseList(List<Task> taskEntity);
}
