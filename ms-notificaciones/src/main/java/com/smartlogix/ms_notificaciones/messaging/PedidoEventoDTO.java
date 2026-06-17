package com.smartlogix.ms_notificaciones.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTO del evento de pedido creado, recibido desde RabbitMQ
 * (publicado por el microservicio ms-pedidos).
 *
 * @author SmartLogix Team
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEventoDTO {
    private String pedidoId;
    private String clienteId;
    private BigDecimal total;
}
