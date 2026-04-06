package com.smartlogix.ms_pedidos.dto;

import lombok.Data;

@Data
public class DetallePedidoRequest {
    private String productoId;
    private Integer cantidad;
}