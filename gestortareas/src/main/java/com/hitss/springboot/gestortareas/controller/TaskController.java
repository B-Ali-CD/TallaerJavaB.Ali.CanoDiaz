package com.hitss.springboot.gestortareas.controller;

import com.hitss.springboot.gestortareas.dto.taskRequest;
import com.hitss.springboot.gestortareas.dto.taskResponse;
import com.hitss.springboot.gestortareas.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@Tag(name = "Tasks", description = "API de Gestión de Tareas")
public class TaskController {
    private final TaskService taskService;
    
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Obtener todas las tareas (solo ADMIN)")
    public ResponseEntity<List<taskResponse>> getAllTasks() throws Exception {
        return ResponseEntity.ok(taskService.findAllTasks());
    }
    
    @GetMapping("/my-tasks")
    @Operation(summary = "Obtener mis tareas")
    public ResponseEntity<List<taskResponse>> getMyTasks() throws Exception {
        return ResponseEntity.ok(taskService.findTasksByCurrentUser());
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener una tarea por ID")
    public ResponseEntity<taskResponse> getTaskById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(taskService.findTaskById(id));
    }
    
    @PostMapping
    @Operation(summary = "Crear una nueva tarea")
    public ResponseEntity<taskResponse> createTask(@Valid @RequestBody taskRequest taskRequest) throws Exception {
        return ResponseEntity.ok(taskService.createTask(taskRequest));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una tarea existente")
    public ResponseEntity<taskResponse> updateTask(@PathVariable Long id, 
            @Valid @RequestBody taskRequest taskRequest) throws Exception {
        return ResponseEntity.ok(taskService.updateTask(id, taskRequest));
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una tarea")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) throws Exception {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}