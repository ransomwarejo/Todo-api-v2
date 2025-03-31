package com.sogel.todo_api_v2.todo_api.service;

import com.sogel.todo_api_v2.todo_api.dto.TaskRequest;
import com.sogel.todo_api_v2.todo_api.model.Task;
import com.sogel.todo_api_v2.todo_api.model.TaskStatus;
import com.sogel.todo_api_v2.todo_api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class TaskService {
    private TaskRepository taskRepository;



    // Convertir Task -> TaskDTO
    private TaskRequest convertToDTO(Task task) {
        return new TaskRequest(task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus().name());
    }


    public List<TaskRequest> getallTasks() {

        return taskRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public Optional<TaskRequest> getTaskById(Long id) {

        return taskRepository.findById(id)
                .map(this::convertToDTO);
    }

    public TaskRequest createTask(Task task) {
        Task savedTask = taskRepository.save(task);
        return convertToDTO(savedTask);
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


    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }
}
