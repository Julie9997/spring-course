package ru.julie.hw_task_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.julie.hw_task_manager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
