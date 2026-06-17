package com.smartlogix.ms_notificaciones.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

/**
 * DTO de salida con los datos públicos de una notificación.
 *
 * @author SmartLogix Team
 */
@Data
@AllArgsConstructor
public class NotificacionResponse {
    private Long id;
    private Long usuarioId;
    private String mensaje;
    private LocalDateTime fechaEnvio;
}
