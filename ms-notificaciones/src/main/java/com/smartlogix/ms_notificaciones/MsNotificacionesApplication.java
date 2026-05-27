package com.smartlogix.ms_notificaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Punto de entrada del microservicio de notificaciones de SmartLogix.
 * <p>
 * Recibe y persiste notificaciones enviadas por otros microservicios
 * (pedidos, envíos) y las expone para consulta por usuario.
 * </p>
 *
 * @author SmartLogix Team
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MsNotificacionesApplication {

    /**
     * Inicia el microservicio de notificaciones.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(MsNotificacionesApplication.class, args);
    }
}