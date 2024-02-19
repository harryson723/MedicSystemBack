package com.application.rest.controllers.dto;

import com.application.rest.entities.UserEntity;
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
    private String typeService;
    private UserEntity provider;
}
