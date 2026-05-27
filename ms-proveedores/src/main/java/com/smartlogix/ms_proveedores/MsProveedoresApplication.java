package com.smartlogix.ms_proveedores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Punto de entrada del microservicio de proveedores de SmartLogix.
 * <p>
 * Gestiona el registro y mantenimiento de los proveedores de productos
 * del sistema logístico.
 * </p>
 *
 * @author SmartLogix Team
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MsProveedoresApplication {

    /**
     * Inicia el microservicio de proveedores.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(MsProveedoresApplication.class, args);
    }
}