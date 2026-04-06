package com.smartlogix.ms_clientes.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PedidoResponse {
    private String id;
    private String clienteId;
    private String estado;
    private String tipo;
    private BigDecimal total;
    private LocalDateTime createdAt;
}