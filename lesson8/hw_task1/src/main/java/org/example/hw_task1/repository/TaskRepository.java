package org.example.hw_task1.repository;

import org.example.hw_task1.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}