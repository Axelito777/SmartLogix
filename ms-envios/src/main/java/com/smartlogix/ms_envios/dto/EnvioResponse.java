package com.smartlogix.ms_envios.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

/**
 * DTO de salida con los datos públicos de un envío.
 *
 * @author SmartLogix Team
 */
@Data
@AllArgsConstructor
public class EnvioResponse {
    private Long id;
    private String pedidoId;
    private String trackingNumber;
    private String estado;
    private String transportista;
    private LocalDateTime fechaCreacion;
}
