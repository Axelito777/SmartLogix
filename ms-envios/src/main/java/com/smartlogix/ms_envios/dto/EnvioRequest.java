package com.smartlogix.ms_envios.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO de entrada con los datos requeridos para crear un envío.
 *
 * @author SmartLogix Team
 */
@Data
public class EnvioRequest {

    @NotNull(message = "El pedidoId es obligatorio")
    private String pedidoId;

    private String transportista;
}
