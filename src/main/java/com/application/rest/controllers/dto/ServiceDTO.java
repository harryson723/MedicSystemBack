package com.application.rest.controllers.dto;

import com.application.rest.entities.UserEntity;
import com.application.rest.entities.types.ServiceType;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String status;
    private ServiceType typeService;
    private UserEntity provider;
    private Long providerId;
}
