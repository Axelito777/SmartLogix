package com.smartlogix.ms_envios.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "envios")
@Data
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedidoId;
    private String direccionDestino;
    private String estado; // Ej: EN_PREPARACION, EN_TRANSITO, ENTREGADO
    private String numeroTracking;
    private LocalDateTime fechaCreacion;
}