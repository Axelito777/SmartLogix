package com.smartlogix.ms_pedidos.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);
        return template;
    }
}
