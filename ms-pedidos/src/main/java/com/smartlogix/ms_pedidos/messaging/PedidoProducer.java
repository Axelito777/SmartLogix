package com.smartlogix.ms_pedidos.messaging;

import com.smartlogix.ms_pedidos.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoProducer {

    private final RabbitTemplate rabbitTemplate;

    public void enviarPedidoCreado(PedidoEventoDTO evento) {
        rabbitTemplate.convertAndSend(
            RabbitMQConfig.EXCHANGE_PEDIDOS,
            RabbitMQConfig.ROUTING_KEY_PEDIDO_CREADO,
            evento
        );
        log.info("Evento pedido.creado enviado para pedido {}", evento.getPedidoId());
    }
}
