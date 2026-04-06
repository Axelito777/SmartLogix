package com.smartlogix.ms_pedidos.dto;

import lombok.Data;
import java.util.List;

@Data
public class PedidoRequest {
    private String clienteId;
    private String tipo;
    private List<DetallePedidoRequest> productos;
}