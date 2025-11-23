package com.todo.TodoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
public class TodoAppApplication {

    static void main(String[] args) {
        SpringApplication.run(TodoAppApplication.class, args);
    }

}
