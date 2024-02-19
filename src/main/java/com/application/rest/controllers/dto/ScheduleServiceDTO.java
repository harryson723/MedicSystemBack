package com.application.rest.controllers.dto;

import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleServiceDTO {
    private Long id;
    private String username;
}
