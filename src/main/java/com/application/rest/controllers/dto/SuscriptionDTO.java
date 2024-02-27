package com.application.rest.controllers.dto;

import com.application.rest.entities.UserEntity;
import com.application.rest.entities.types.StatusType;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuscriptionDTO {
    private Long id;
    private StatusType status;
    private UserEntity provider;
    private UserEntity client;
    private Long providerId;
    private Long clientId;
}
