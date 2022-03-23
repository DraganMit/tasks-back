package com.example.tasks.service;

import com.example.tasks.model.Task;
import com.example.tasks.repo.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {
    private final TasksRepo tasksRepo;

    @Autowired
    public TasksService(TasksRepo tasksRepo) {
        this.tasksRepo = tasksRepo;
    }

    public Task addTask(Task task) {
        return tasksRepo.save(task);
    }

    public Optional<Task> findTasksById(int id) {
        return tasksRepo.findById(id);
    }

    public List<Task> findAllTasks() {
        return tasksRepo.findAll();
    }

    public void deleteTask(int id) {
        tasksRepo.deleteById(id);
    }

    public Task updateTask(Task task) {
        return tasksRepo.save(task);
    }

}
