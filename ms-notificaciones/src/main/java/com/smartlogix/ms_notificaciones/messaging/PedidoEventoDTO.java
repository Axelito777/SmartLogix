package com.smartlogix.ms_notificaciones.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEventoDTO {
    private String pedidoId;
    private String clienteId;
    private BigDecimal total;
}
