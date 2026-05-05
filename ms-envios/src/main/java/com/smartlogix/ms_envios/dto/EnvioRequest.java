package com.smartlogix.ms_envios.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnvioRequest {

    @NotNull(message = "El pedidoId es obligatorio")
    private String pedidoId;

    private String transportista;
}
