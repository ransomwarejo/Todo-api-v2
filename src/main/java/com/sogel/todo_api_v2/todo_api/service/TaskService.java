package com.sogel.todo_api_v2.todo_api.service;

import com.sogel.todo_api_v2.todo_api.model.Task;
import com.sogel.todo_api_v2.todo_api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class TaskService {
    private TaskRepository taskRepository;

    public List<Task> getallTasks() {
        return taskRepository.findAll();
    }


    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(existingTask -> {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setStatus(updatedTask.getStatus());
            return taskRepository.save(existingTask);
                }
        );
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
