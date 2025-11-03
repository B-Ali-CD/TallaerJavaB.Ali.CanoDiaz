package com.hitss.springboot.gestortareas.service;

import com.hitss.springboot.gestortareas.dto.taskRequest;
import com.hitss.springboot.gestortareas.dto.taskResponse;
import com.hitss.springboot.gestortareas.entity.Task;
import com.hitss.springboot.gestortareas.entity.User;
import com.hitss.springboot.gestortareas.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;

    /**
     * Obtiene todas las tareas del sistema (solo visible para administradores)
     * @throws Exception 
     */
    public List<taskResponse> findAllTasks() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Verifica si el usuario tiene rol de administrador
        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        if (!isAdmin) {
            throw new Exception();
        }

        // Convierte las entidades a DTOs de respuesta
        return taskRepository.findAll().stream()
                .map(taskResponse::new)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene las tareas del usuario autenticado
     * @throws Exception 
     */
    public List<taskResponse> findTasksByCurrentUser() throws Exception {
        String username = getCurrentUsername();
        User user = null;
        try {
            user = userService.findByUsername(username)
                    .orElseThrow(() -> new Exception("Usuario no encontrado"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Busca solo tareas creadas por ese usuario
        return taskRepository.findByUser(user).stream()
                .map(taskResponse::new)
                .collect(Collectors.toList());
    }

    /**
     *  Obtiene una tarea por su ID (solo si pertenece al usuario o si es admin)
     * @throws Exception 
     */
    public taskResponse findTaskById(Long id) throws Exception {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new Exception("Tarea no encontrada con id: " + id));

        checkTaskOwnershipOrAdmin(task);
        return new taskResponse(task);
    }

    /**
     * Crea una nueva tarea asociada al usuario autenticado
     * @throws Exception 
     */
    public taskResponse createTask(taskRequest request) throws Exception {
        String username = getCurrentUsername();
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        // Validación simple: el título no puede estar vacío
        if (request.getTitle() == null || request.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("El título de la tarea es obligatorio");
        }

        // Convierte el DTO a entidad y asigna el usuario autenticado
        Task task = request.toEntity();
        task.setUser(user);

        Task savedTask = taskRepository.save(task);
        return new taskResponse(savedTask);
    }

    /**
     *  Actualiza una tarea existente (solo si pertenece al usuario o si es admin)
     * @throws Exception 
     */
    public taskResponse updateTask(Long id, taskRequest request) throws Exception {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new Exception("Tarea no encontrada con id: " + id));

        checkTaskOwnershipOrAdmin(task);

        // Actualiza solo los campos enviados (permite actualización parcial)
        if (request.getTitle() != null && !request.getTitle().isBlank()) {
            task.setTitle(request.getTitle());
        }
        if (request.getDescription() != null) {
            task.setDescription(request.getDescription());
        }
        if (request.getStatus() != null) {
            task.setStatus(request.getStatus());
        }

        Task updatedTask = taskRepository.save(task);
        return new taskResponse(updatedTask);
    }

    /**
     * Elimina una tarea (solo propietario o admin)
     * @throws Exception 
     */
    public void deleteTask(Long id) throws Exception {
        Task task = null;
        try {
            task = taskRepository.findById(id)
                    .orElseThrow(() -> new Exception("Tarea no encontrada con id: " + id));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        checkTaskOwnershipOrAdmin(task);
        taskRepository.delete(task);
    }

    /**
     * Verifica si el usuario autenticado es el propietario de la tarea o un administrador
     * @throws Exception 
     */
    private void checkTaskOwnershipOrAdmin(Task task) throws Exception {
        String username = getCurrentUsername();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean isAdmin = auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        // Si no es admin ni propietario, lanza excepción
        if (!isAdmin && !task.getUser().getUsername().equals(username)) {
            throw new Exception("No tienes permisos para acceder o modificar esta tarea");
        }
    }

    /**
     *  Obtiene el nombre del usuario autenticado actual
     * @throws Exception 
     */
    private String getCurrentUsername() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() || auth.getName().equals("anonymousUser")) {
            throw new Exception("No hay usuario autenticado");
        }
        return auth.getName();
    }
}