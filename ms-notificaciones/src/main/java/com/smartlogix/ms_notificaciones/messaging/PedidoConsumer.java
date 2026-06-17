package com.smartlogix.ms_notificaciones.messaging;

import com.smartlogix.ms_notificaciones.config.RabbitMQConfig;
import com.smartlogix.ms_notificaciones.dto.NotificacionRequest;
import com.smartlogix.ms_notificaciones.service.NotificacionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Consumidor de eventos de pedidos creados publicados por ms-pedidos a
 * través de RabbitMQ; registra una notificación para el cliente correspondiente.
 *
 * @author SmartLogix Team
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoConsumer {

    private final NotificacionService notificacionService;

    /**
     * Procesa un evento de pedido creado y registra la notificación
     * correspondiente para el cliente.
     *
     * @param evento datos del pedido creado recibidos desde la cola RabbitMQ
     */
    @RabbitListener(queues = RabbitMQConfig.QUEUE_PEDIDOS_CREADOS)
    public void consumir(PedidoEventoDTO evento) {
        log.info("Mensaje recibido: pedido {} creado para cliente {}",
            evento.getPedidoId(), evento.getClienteId());

        NotificacionRequest request = new NotificacionRequest();
        request.setUsuarioId(1L);
        request.setMensaje(String.format(
            "Tu pedido %s fue creado exitosamente. Total: $%s",
            evento.getPedidoId(), evento.getTotal()
        ));

        notificacionService.enviar(request);
        log.info("Notificación registrada para pedido {}", evento.getPedidoId());
    }
}
