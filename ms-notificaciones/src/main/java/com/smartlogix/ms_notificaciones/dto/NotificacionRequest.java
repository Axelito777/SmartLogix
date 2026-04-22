package com.smartlogix.ms_notificaciones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificacionRequest {

    @NotNull(message = "El usuarioId es obligatorio")
    private Long usuarioId;

    @NotBlank(message = "El mensaje es obligatorio")
    private String mensaje;
}
