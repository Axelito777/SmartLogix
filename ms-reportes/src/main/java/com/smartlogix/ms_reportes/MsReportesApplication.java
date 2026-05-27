package com.smartlogix.ms_reportes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Punto de entrada del microservicio de reportes de SmartLogix.
 * <p>
 * Genera reportes agregados de ventas e inventario consultando
 * {@code ms-pedidos} y {@code ms-inventario} vía OpenFeign.
 * </p>
 *
 * @author SmartLogix Team
 */
@SpringBootApplication
@EnableFeignClients
public class MsReportesApplication {

    /**
     * Inicia el microservicio de reportes.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(MsReportesApplication.class, args);
    }
}
