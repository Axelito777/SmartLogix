package com.smartlogix.ms_notificaciones.messaging;

import com.smartlogix.ms_notificaciones.config.RabbitMQConfig;
import com.smartlogix.ms_notificaciones.dto.NotificacionRequest;
import com.smartlogix.ms_notificaciones.service.NotificacionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoConsumer {

    private final NotificacionService notificacionService;

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
