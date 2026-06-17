package com.smartlogix.ms_reportes.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

/**
 * DTO con el reporte agregado de ventas: totales de pedidos por estado,
 * monto recaudado y ticket promedio.
 *
 * @author SmartLogix Team
 */
@Data
@AllArgsConstructor
public class ReporteVentasDTO {
    private int totalPedidos;
    private int pedidosCompletados;
    private int pedidosPendientes;
    private BigDecimal totalRecaudado;
    private BigDecimal ticketPromedio;
}