package com.smartlogix.ms_inventario.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProductoResponse {
    private String id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private Integer stockMinimo;
    private String bodegaId;
    private String proveedorId;
    private LocalDateTime createdAt;
}