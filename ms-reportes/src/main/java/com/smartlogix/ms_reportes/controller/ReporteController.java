package com.smartlogix.ms_reportes.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    // 1. GET /api/reportes/ventas
    @GetMapping("/ventas")
    public Map<String, Object> obtenerReporteVentas() {
        Map<String, Object> reporte = new HashMap<>();
        reporte.put("reporte", "Ventas Mensuales");
        reporte.put("totalVentas", 15420);
        reporte.put("estado", "Completado");
        return reporte;
    }

    // 2. GET /api/reportes/inventario
    @GetMapping("/inventario")
    public Map<String, Object> obtenerReporteInventario() {
        Map<String, Object> reporte = new HashMap<>();
        reporte.put("reporte", "Estado de Inventario");
        reporte.put("productosActivos", 350);
        reporte.put("stockBajo", 12);
        return reporte;
    }
}