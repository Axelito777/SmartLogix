package com.smartlogix.ms_reportes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    // 1. GET /api/reportes/ventas
    @GetMapping("/ventas")
    public Map<String, Object> obtenerReporteVentas() {
        return Map.of(
            "titulo", "Reporte Mensual de Ventas",
            "total_ventas", 15400.50,
            "moneda", "USD",
            "estado", "Completado"
        );
    }

    // 2. GET /api/reportes/inventario
    @GetMapping("/inventario")
    public Map<String, Object> obtenerReporteInventario() {
        return Map.of(
            "titulo", "Estado Actual del Inventario",
            "productos_activos", 120,
            "alerta_stock_bajo", 5,
            "ultima_actualizacion", "2024-03-20T10:00:00"
        );
    }
}