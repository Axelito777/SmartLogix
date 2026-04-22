package com.smartlogix.ms_reportes.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class PedidoDTO {
    private String id;
    private String clienteId;
    private String estado;
    private String tipo;
    private BigDecimal total;
}
