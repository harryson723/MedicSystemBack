package com.application.rest.entities;

import com.application.rest.entities.types.ServiceType;
import com.application.rest.entities.types.StatusType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_service")
    private ServiceType typeService;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    @JsonIgnore
    private UserEntity provider;

}
