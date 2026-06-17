package com.smartlogix.ms_notificaciones.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de RabbitMQ del microservicio de notificaciones: declara
 * la cola, el exchange y el binding usados para recibir eventos de
 * pedidos creados, además del conversor de mensajes JSON.
 *
 * @author SmartLogix Team
 */
@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_PEDIDOS_CREADOS = "pedidos.creados.queue";
    public static final String EXCHANGE_PEDIDOS = "pedidos.exchange";
    public static final String ROUTING_KEY_PEDIDO_CREADO = "pedido.creado";

    /**
     * Declara la cola durable donde se publican los eventos de pedidos creados.
     *
     * @return la cola {@code pedidos.creados.queue}
     */
    @Bean
    public Queue pedidosCreadosQueue() {
        return QueueBuilder.durable(QUEUE_PEDIDOS_CREADOS).build();
    }

    /**
     * Declara el exchange de tipo topic usado para enrutar eventos de pedidos.
     *
     * @return el {@link TopicExchange} {@code pedidos.exchange}
     */
    @Bean
    public TopicExchange pedidosExchange() {
        return new TopicExchange(EXCHANGE_PEDIDOS);
    }

    /**
     * Enlaza la cola de pedidos creados con el exchange de pedidos
     * usando la routing key {@code pedido.creado}.
     *
     * @param pedidosCreadosQueue cola de pedidos creados
     * @param pedidosExchange     exchange de pedidos
     * @return el {@link Binding} resultante
     */
    @Bean
    public Binding bindingPedidosCreados(Queue pedidosCreadosQueue, TopicExchange pedidosExchange) {
        return BindingBuilder.bind(pedidosCreadosQueue)
            .to(pedidosExchange)
            .with(ROUTING_KEY_PEDIDO_CREADO);
    }

    /**
     * Expone el conversor de mensajes que serializa/deserializa los
     * eventos de RabbitMQ como JSON.
     *
     * @return una instancia de {@link Jackson2JsonMessageConverter}
     */
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Construye la fábrica de contenedores de listeners de RabbitMQ,
     * configurada para deserializar los mensajes recibidos como JSON.
     *
     * @param connectionFactory fábrica de conexiones a RabbitMQ
     * @param messageConverter  conversor de mensajes JSON
     * @return la {@link SimpleRabbitListenerContainerFactory} configurada
     */
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory,
            Jackson2JsonMessageConverter messageConverter) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(messageConverter);
        return factory;
    }
}
