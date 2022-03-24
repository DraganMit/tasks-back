package com.example.tasks.model;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private String category;

    private String description;

    private LocalDate dueDate;

    @Range(min= 1, max= 10)
    private int priority;

    public Task(String title, String category, String description, int priority, LocalDate dueDate) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

}