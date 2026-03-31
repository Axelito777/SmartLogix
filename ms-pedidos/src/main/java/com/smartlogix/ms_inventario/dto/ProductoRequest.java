package com.smartlogix.ms_inventario.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductoRequest {
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private Integer stockMinimo;
    private String bodegaId;
    private String proveedorId;
}