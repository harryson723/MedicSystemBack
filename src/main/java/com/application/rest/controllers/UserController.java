package com.application.rest.controllers;

import com.application.rest.controllers.dto.UserDTO;
import com.application.rest.entities.RoleEntity;
import com.application.rest.entities.UserEntity;
import com.application.rest.entities.types.RolType;
import com.application.rest.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserService userService;

    @GetMapping("/client")
    public ResponseEntity<?> findAllClient() {
        List<UserDTO> users = userService.findByRolesName(RolType.CLIENT)
                .stream()
                .map(user -> UserDTO.builder()
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .firstname(user.getFirstname())
                        .lastname(user.getLastname())
                        .documentNumber(user.getDocumentNumber())
                        .documentType(user.getDocumentType())
                        .id(user.getId())
                        .build()
                ).toList();
        return  ResponseEntity.ok(users);
    }

    @GetMapping("/provider")
    public ResponseEntity<?> findAllProvider() {
        List<UserDTO> users = userService.findByRolesName(RolType.PROVIDER)
                .stream()
                .map(user -> UserDTO.builder()
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .firstname(user.getFirstname())
                        .lastname(user.getLastname())
                        .documentNumber(user.getDocumentNumber())
                        .documentType(user.getDocumentType())
                        .id(user.getId())
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
                .documentNumber(user.getDocumentNumber())
                .documentType(user.getDocumentType())
                .build();
        return  ResponseEntity.ok(userDTO);
    }
    @GetMapping("/documentNumber")
    public ResponseEntity<?> findByDocumentNumber(@RequestParam String documentNumber, @RequestParam String rol) {
        Optional<UserEntity> userOptional = userService.findByDocumentNumberAndRolesName(documentNumber, RolType.valueOf(rol));
        if(userOptional.isEmpty()) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "No existe el documento ingresado");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        UserEntity user = userOptional.get();
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .documentNumber(user.getDocumentNumber())
                .documentType(user.getDocumentType())
                .build();
        return  ResponseEntity.ok(userDTO);
    }
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) throws URISyntaxException {
        if(userDTO.getUsername().isBlank()) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "El nombre de usuario no puede estar en blanco");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
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
                .documentNumber(userDTO.getDocumentNumber())
                .documentType(userDTO.getDocumentType())
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
