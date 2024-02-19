package com.application.rest.controllers;

import com.application.rest.controllers.dto.UserDTO;
import com.application.rest.entities.RoleEntity;
import com.application.rest.entities.UserEntity;
import com.application.rest.entities.types.RolType;
import com.application.rest.services.IUserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        List<UserDTO> users = userService.findAll()
                .stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .firstname(user.getFirstname())
                        .lastname(user.getLastname())
                        .build()
                ).toList();
        return  ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<UserEntity> userOptional = userService.findById(id);
        if(userOptional.isEmpty()) return ResponseEntity.notFound().build();

        UserEntity user = userOptional.get();
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .build();
        return  ResponseEntity.ok(userDTO);
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) throws URISyntaxException {
        if(userDTO.getUsername().isBlank()) return ResponseEntity.badRequest().build();
        Set<RoleEntity> rol = userDTO.getRol().stream()
                .map(rols -> RoleEntity.builder()
                        .name(RolType.valueOf(rols))
                        .build())
                .collect(Collectors.toSet());

        UserEntity user = UserEntity.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .firstname(userDTO.getFirstname())
                .lastname(userDTO.getLastname())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .roles(rol)
                .build();

        userService.save(user);
        return  ResponseEntity.created(new URI("/v1/api/user/")).body("Usuario creado exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        Optional<UserEntity> userOptional = userService.findById(id);
        if(userOptional.isEmpty()) return ResponseEntity.notFound().build();

        UserEntity user = userOptional.get();
        user.setUsername(userDTO.getUsername());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        userService.save(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if(id == null) return ResponseEntity.badRequest().build();

        Optional<UserEntity> userOptional = userService.findById(id);
        if(userOptional.isEmpty()) return ResponseEntity.notFound().build();

        userService.deleteById(id);
        return  ResponseEntity.ok("Usuario eliminado con exito");
    }
}
