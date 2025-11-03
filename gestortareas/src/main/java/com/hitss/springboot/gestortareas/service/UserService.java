package com.hitss.springboot.gestortareas.service;

import com.hitss.springboot.gestortareas.entity.Role;
import com.hitss.springboot.gestortareas.entity.User;
import com.hitss.springboot.gestortareas.repository.RoleRepository;
import com.hitss.springboot.gestortareas.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    //Buscar usuario por nombre de usuario
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    //Verificar si el username ya existe
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    //Verificar si el email ya existe
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    //Guardar usuario con contraseña encriptada
    public User save(User user) {
        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    //Obtener todos los usuarios (idealmente restringido a ADMIN)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    //Buscar usuario por ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    //Eliminar usuario por ID
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Convierte una lista de nombres de roles (String)
     *    en un conjunto de entidades Role desde la base de datos.
     *    Si no se especifican roles, asigna ROLE_USER por defecto.
     */
    public Set<Role> getRolesFromNames(Set<String> strRoles) {
        // Si el conjunto de roles es nulo o vacío, asignar por defecto ROLE_USER
        if (strRoles == null || strRoles.isEmpty()) {
            Role userRole = roleRepository.findByName(Role.ERole.ROLE_USER);
            return Collections.singleton(userRole);
        }

        //Corregido: usamos strRoles.stream(), no Strings.stream()
        return strRoles.stream()
                .map(role -> {
                    switch (role.toLowerCase()) {
                        case "admin":
                            return roleRepository.findByName(Role.ERole.ROLE_ADMIN);
                        case "user":
                        default:
                            return roleRepository.findByName(Role.ERole.ROLE_USER);
                    }
                })
                .collect(Collectors.toSet());
    }
}