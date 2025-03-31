package com.sogel.todo_api_v2.todo_api.controller;


import com.sogel.todo_api_v2.todo_api.dto.TaskRequest;
import com.sogel.todo_api_v2.todo_api.model.Task;
import com.sogel.todo_api_v2.todo_api.model.TaskStatus;
import com.sogel.todo_api_v2.todo_api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/tasks")
public class TaskController {

    private TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<List<TaskRequest>> getAllTasks(){
        List<TaskRequest> allTasks = taskService.getallTasks();
        return ResponseEntity.ok(allTasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskRequest> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TaskRequest> createTask(@PathVariable Task task){
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable TaskStatus status) {
        return ResponseEntity.ok(taskService.getTasksByStatus(status));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id ,@RequestBody Task updatedTask){
        return taskService.updateTask(id,updatedTask)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


}
