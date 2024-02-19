package com.application.rest.entities;

import com.application.rest.entities.types.StatusType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "suscription")
public class SuscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    @JsonIgnore
    private UserEntity provider;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnore
    private UserEntity client;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;
}
