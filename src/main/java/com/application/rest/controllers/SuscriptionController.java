package com.application.rest.controllers;

import com.application.rest.controllers.dto.SuscriptionDTO;
import com.application.rest.controllers.dto.UserDTO;
import com.application.rest.entities.SuscriptionEntity;
import com.application.rest.entities.UserEntity;
import com.application.rest.services.ISuscriptionService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/suscription")
public class SuscriptionController {
    @Autowired
    private ISuscriptionService suscriptionService;

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        List<SuscriptionDTO> suscriptions = suscriptionService.findAll()
                .stream()
                .map(suscription -> {
                            UserEntity provider = suscription.getProvider();
                            UserEntity client = suscription.getClient();
                            return SuscriptionDTO.builder()
                                    .id(suscription.getId())
                                    .status(String.valueOf(suscription.getStatus()))
                                    .provider(provider)
                                    .client(client)
                                    .build();
                        }
                ).toList();
        return ResponseEntity.ok(suscriptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<SuscriptionEntity> suscriptionOptional = suscriptionService.findById(id);
        if (suscriptionOptional.isEmpty()) return ResponseEntity.notFound().build();

        SuscriptionEntity suscription = suscriptionOptional.get();
        UserEntity provider = suscription.getProvider();
        UserEntity client = suscription.getClient();
        SuscriptionDTO suscriptionDTO = SuscriptionDTO.builder()
                .id(suscription.getId())
                .status(String.valueOf(suscription.getStatus()))
                .provider(provider)
                .client(client)
                .build();
        return ResponseEntity.ok(suscriptionDTO);
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody SuscriptionDTO suscriptionDTO) throws URISyntaxException {
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
        return ResponseEntity.created(new URI("/v1/api/suscription/")).body("Suscripcion creada exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SuscriptionDTO suscriptionDTO) {
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
        return ResponseEntity.ok("Suscripcion eliminado con exito");
    }
}
