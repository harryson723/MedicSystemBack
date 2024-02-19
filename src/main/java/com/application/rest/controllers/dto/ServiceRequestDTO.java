package com.application.rest.controllers.dto;

import com.application.rest.entities.UserEntity;
import lombok.*;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceRequestDTO {
    private Long id;
    private String status;
    private List<UserEntity> provider;
    private List<UserEntity> client;
}
