package com.example.tasks.controller;

import com.example.tasks.model.Task;
import com.example.tasks.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TasksController {
    private final TasksService tasksService;

    @Autowired
    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks() {
        return tasksService.findAllTasks();
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task getTaskById(@PathVariable int id) {
        Optional<Task> optional = tasksService.findTasksById(id);
        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Task with that id");
        }
        return optional.get();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task) {
        Task newTask = tasksService.addTask(task);
        return newTask;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Task updateTask(@RequestBody Task task) {
        return tasksService.updateTask(task);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable int id) {
        Optional<Task> optional = tasksService.findTasksById(id);
        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Task with that id");
        }
        tasksService.deleteTask(id);
    }

    @GetMapping
    public String hello() {
        return "Hello";
    }
}
