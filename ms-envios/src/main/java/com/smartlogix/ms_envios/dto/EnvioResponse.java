package com.smartlogix.ms_envios.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EnvioResponse {
    private Long id;
    private Long pedidoId;
    private String trackingNumber;
    private String estado;
    private String transportista;
    private LocalDateTime fechaCreacion;
}
