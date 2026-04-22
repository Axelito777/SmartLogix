package com.smartlogix.ms_reportes.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ReporteInventarioDTO {
    private int totalProductos;
    private int productosBajoStock;
    private BigDecimal valorTotalInventario;
}
