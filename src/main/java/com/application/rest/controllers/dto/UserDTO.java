package com.application.rest.controllers.dto;

import lombok.*;

import java.util.Set;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String documentNumber;
    private String documentType;
    private Set<String> rol;

}
