package com.application.rest.controllers;

import com.application.rest.controllers.dto.ServiceDTO;
import com.application.rest.entities.ServiceEntity;
import com.application.rest.entities.UserEntity;
import com.application.rest.services.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/service")
public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        List<ServiceDTO> services = serviceService.findAll()
                .stream()
                .map(service -> ServiceDTO.builder()
                        .id(service.getId())
                        .name(service.getName())
                        .description(service.getDescription())
                        .typeService(String.valueOf(service.getTypeService()))
                        .price(service.getPrice())
                        .status(String.valueOf(service.getStatus()))
                        .provider(service.getProvider())
                        .build()
                ).toList();
        return  ResponseEntity.ok(services);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<ServiceEntity> serviceOptional = serviceService.findById(id);
        if(serviceOptional.isEmpty()) return ResponseEntity.notFound().build();

        ServiceEntity service = serviceOptional.get();
        ServiceDTO serviceDTO = ServiceDTO.builder()
                .id(service.getId())
                .name(service.getName())
                .description(service.getDescription())
                .typeService(String.valueOf(service.getTypeService()))
                .price(service.getPrice())
                .status(String.valueOf(service.getStatus()))
                .provider(service.getProvider())
                .build();
        return  ResponseEntity.ok(serviceDTO);
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody ServiceDTO serviceDTO) throws URISyntaxException {
        /*
        if(userDTO.getUsername().isBlank()) return ResponseEntity.badRequest().build();
        UserEntity user = UserEntity.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .firstname(userDTO.getFirstname())
                .lastname(userDTO.getLastname())
                .rol(RolType.valueOf(userDTO.getRol()))
                .password(userDTO.getPassword())
                .build();

        suscriptionService.save(user);

         */
        return  ResponseEntity.created(new URI("/v1/api/suscription/")).body("Suscripcion creada exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ServiceDTO serviceDTO) {
        /*
        Optional<UserEntity> userOptional = suscriptionService.findById(id);
        if(userOptional.isEmpty()) return ResponseEntity.notFound().build();

        UserEntity user = userOptional.get();
        user.setUsername(userDTO.getUsername());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setEmail(userDTO.getEmail());
        suscriptionService.save(user);
         */
        return ResponseEntity.ok("Hola");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        /*
        if(id == null) return ResponseEntity.badRequest().build();

        Optional<UserEntity> userOptional = suscriptionService.findById(id);
        if(userOptional.isEmpty()) return ResponseEntity.notFound().build();

        suscriptionService.deleteById(id);
        */
        return  ResponseEntity.ok("Suscripcion eliminado con exito");
    }
}
