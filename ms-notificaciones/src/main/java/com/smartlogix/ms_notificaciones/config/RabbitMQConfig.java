package com.smartlogix.ms_notificaciones.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_PEDIDOS_CREADOS = "pedidos.creados.queue";
    public static final String EXCHANGE_PEDIDOS = "pedidos.exchange";
    public static final String ROUTING_KEY_PEDIDO_CREADO = "pedido.creado";

    @Bean
    public Queue pedidosCreadosQueue() {
        return QueueBuilder.durable(QUEUE_PEDIDOS_CREADOS).build();
    }

    @Bean
    public TopicExchange pedidosExchange() {
        return new TopicExchange(EXCHANGE_PEDIDOS);
    }

    @Bean
    public Binding bindingPedidosCreados(Queue pedidosCreadosQueue, TopicExchange pedidosExchange) {
        return BindingBuilder.bind(pedidosCreadosQueue)
            .to(pedidosExchange)
            .with(ROUTING_KEY_PEDIDO_CREADO);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

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
