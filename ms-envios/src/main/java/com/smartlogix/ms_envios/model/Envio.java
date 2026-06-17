package com.smartlogix.ms_envios.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Entidad JPA que representa el envío asociado a un pedido, con su
 * número de seguimiento, estado y transportista.
 *
 * @author SmartLogix Team
 */
@Data
@Entity
@Table(name = "envios")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pedido_id", nullable = false)
    private String pedidoId;

    @Column(name = "tracking_number", unique = true, nullable = false)
    private String trackingNumber;

    @Column(nullable = false)
    private String estado;

    private String transportista;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    /**
     * Inicializa las marcas de tiempo de creación y actualización antes de
     * persistir el envío por primera vez.
     */
    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        fechaActualizacion = LocalDateTime.now();
    }

    /**
     * Actualiza la marca de tiempo de última modificación antes de
     * persistir un cambio sobre el envío.
     */
    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }
}