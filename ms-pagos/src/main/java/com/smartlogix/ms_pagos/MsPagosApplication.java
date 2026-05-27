package com.smartlogix.ms_pagos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Punto de entrada del microservicio de pagos de SmartLogix.
 * <p>
 * Procesa y registra los pagos asociados a pedidos,
 * consultables posteriormente por pedido o individualmente.
 * </p>
 *
 * @author SmartLogix Team
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MsPagosApplication {

    /**
     * Inicia el microservicio de pagos.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(MsPagosApplication.class, args);
    }
}
