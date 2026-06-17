package com.smartlogix.ms_notificaciones.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Entidad JPA que representa una notificación enviada a un usuario.
 *
 * @author SmartLogix Team
 */
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

    /**
     * Inicializa la marca de tiempo de envío antes de persistir la
     * notificación por primera vez.
     */
    @PrePersist
    protected void onCreate() {
        fechaEnvio = LocalDateTime.now();
    }
}