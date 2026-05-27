package com.smartlogix.ms_envios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Punto de entrada del microservicio de envíos de SmartLogix.
 * <p>
 * Gestiona la creación y seguimiento de envíos asociados a pedidos,
 * genera números de tracking y notifica a {@code ms-notificaciones} al crear un envío.
 * </p>
 *
 * @author SmartLogix Team
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsEnviosApplication {

    /**
     * Inicia el microservicio de envíos.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(MsEnviosApplication.class, args);
    }
}