package com.smartlogix.ms_reportes.dto;

import lombok.Data;
import java.math.BigDecimal;

/**
 * DTO con los datos de un pedido, recibido desde el microservicio
 * ms-pedidos a través de {@link com.smartlogix.ms_reportes.client.PedidosClient}.
 *
 * @author SmartLogix Team
 */
@Data
public class PedidoDTO {
    private String id;
    private String clienteId;
    private String estado;
    private String tipo;
    private BigDecimal total;
}
