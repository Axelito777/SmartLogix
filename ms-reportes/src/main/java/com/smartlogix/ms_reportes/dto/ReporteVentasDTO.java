package com.smartlogix.ms_reportes.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ReporteVentasDTO {
    private int totalPedidos;
    private int pedidosCompletados;
    private int pedidosPendientes;
    private BigDecimal totalRecaudado;
    private BigDecimal ticketPromedio;
}