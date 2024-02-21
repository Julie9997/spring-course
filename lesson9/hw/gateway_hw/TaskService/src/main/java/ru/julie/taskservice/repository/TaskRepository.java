package ru.julie.taskservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.julie.taskservice.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}