package com.smartlogix.ms_notificaciones.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class NotificacionResponse {
    private Long id;
    private Long usuarioId;
    private String mensaje;
    private LocalDateTime fechaEnvio;
}
