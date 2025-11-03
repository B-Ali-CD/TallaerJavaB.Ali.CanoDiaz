package com.hitss.springboot.gestortareas.repository;

import com.hitss.springboot.gestortareas.entity.Task;
import com.hitss.springboot.gestortareas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
    List<Task> findByUserId(Long userId);
    Optional<Task> findByIdAndUser(Long id, User user);
}