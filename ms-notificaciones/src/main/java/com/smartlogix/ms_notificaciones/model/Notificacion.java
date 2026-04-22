package com.smartlogix.ms_notificaciones.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notificaciones")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private String mensaje;

    @Column(name = "fecha_envio")
    private LocalDateTime fechaEnvio;

    @PrePersist
    protected void onCreate() {
        fechaEnvio = LocalDateTime.now();
    }
}