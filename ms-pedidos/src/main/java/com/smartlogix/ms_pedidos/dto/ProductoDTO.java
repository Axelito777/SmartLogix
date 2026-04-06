package com.smartlogix.ms_pedidos.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductoDTO {
    private String id;
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
}