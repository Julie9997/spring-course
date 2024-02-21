package ru.julie.taskservice.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tasks")
public class Task {
    public enum Status {
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime leadTime;

}