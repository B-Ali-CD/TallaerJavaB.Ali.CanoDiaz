package com.hitss.springboot.gestortareas.repository;


import com.hitss.springboot.gestortareas.entity.Role;
import com.hitss.springboot.gestortareas.entity.Role.ERole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole roleAdmin);
}