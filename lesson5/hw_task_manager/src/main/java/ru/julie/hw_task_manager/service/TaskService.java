package ru.julie.hw_task_manager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.julie.hw_task_manager.model.Task;
import ru.julie.hw_task_manager.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    /**
     * Получение списка всех задач
     * @return список задач
     */
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    /**
     * Поиск задач по id
     * @param id
     * @return
     */
    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    /**
     * поиск задач по статусу
     * @param status
     * @return список задач по статусу
     */
    public List<Task> getTaskByStatus(Task.Status status) {
        List<Task> tasks = repository.findAll();
        return tasks.stream().filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    /**
     * Создание задачи
     * @param task
     * @return созданная книга
     */
    public Task createTask(Task task) {
        task.setStatus(Task.Status.NOT_STARTED);
        task.setLeadTime(LocalDateTime.now());
        repository.save(task);
        return task;
    }

    /**
     * Обновление задачи
     * @param id
     * @param taskDetails
     * @return обновленная книга
     */
    public Task ubdateTask(Long id, Task taskDetails) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setId(taskDetails.getId());
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.getStatus());
            task.setLeadTime(taskDetails.getLeadTime());
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    /**
     * изменение статуса задачи
     * @param id
     * @param taskData
     */
    public void changeStatus(Long id, Task taskData) {
        Task task = getTaskById(id).orElse(null);
        if (task != null){
            task.setStatus(taskData.getStatus());
            repository.save(task);
        }
    }

    /**
     * удаление задачи по id
     * @param id
     */
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
