package com.smartlogix.ms_reportes.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

/**
 * DTO con el reporte agregado de inventario: total de productos,
 * productos bajo el stock mínimo y valor total del inventario.
 *
 * @author SmartLogix Team
 */
@Data
@AllArgsConstructor
public class ReporteInventarioDTO {
    private int totalProductos;
    private int productosBajoStock;
    private BigDecimal valorTotalInventario;
}
