package com.smartlogix.ms_notificaciones.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificaciones")
@Data
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuarioId; // ID del cliente al que se le notifica
    private String mensaje;
    private String tipo; // Ej: EMAIL, SMS, PUSH
    private LocalDateTime fechaEnvio;
}