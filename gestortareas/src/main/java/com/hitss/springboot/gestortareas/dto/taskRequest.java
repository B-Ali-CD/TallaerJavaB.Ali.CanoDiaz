package com.hitss.springboot.gestortareas.dto;

import com.hitss.springboot.gestortareas.entity.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class taskRequest {
    @NotBlank(message = "El título es obligatorio")
    @Size(max = 100, message = "El título no puede tener más de 100 caracteres")
    private String title;
    
    @Size(max = 500, message = "La descripción no puede tener más de 500 caracteres")
    private String description;
    
    private Task.TaskStatus status;
    
    // Método para convertir a entidad
    public Task toEntity() {
        Task task = new Task();
        task.setTitle(this.title);
        task.setDescription(this.description);
        task.setStatus(this.status != null ? this.status : Task.TaskStatus.PENDING);
        return task;
    }
}