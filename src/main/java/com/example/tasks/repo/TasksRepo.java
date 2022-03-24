package com.example.tasks.repo;

import com.example.tasks.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepo extends JpaRepository<Task, Integer> {

}
