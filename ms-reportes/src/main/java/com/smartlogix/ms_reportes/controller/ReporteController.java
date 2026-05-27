package com.smartlogix.ms_reportes.controller;

import com.smartlogix.ms_reportes.dto.ReporteInventarioDTO;
import com.smartlogix.ms_reportes.dto.ReporteVentasDTO;
import com.smartlogix.ms_reportes.service.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para la generación de reportes de negocio.
 * <p>
 * Expone endpoints de consulta para reportes de ventas e inventario
 * bajo la ruta base {@code /api/reportes}.
 * </p>
 *
 * @author SmartLogix Team
 */
@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    /**
     * Genera y retorna el reporte consolidado de ventas.
     * <p>
     * Incluye total de pedidos, pedidos completados y pendientes,
     * total recaudado y ticket promedio.
     * </p>
     *
     * @return {@code 200 OK} con el {@link ReporteVentasDTO} calculado
     */
    @GetMapping("/ventas")
    public ResponseEntity<ReporteVentasDTO> reporteVentas() {
        return ResponseEntity.ok(reporteService.generarReporteVentas());
    }

    /**
     * Genera y retorna el reporte consolidado del inventario.
     * <p>
     * Incluye total de productos, cantidad con bajo stock y valor total del inventario.
     * </p>
     *
     * @return {@code 200 OK} con el {@link ReporteInventarioDTO} calculado
     */
    @GetMapping("/inventario")
    public ResponseEntity<ReporteInventarioDTO> reporteInventario() {
        return ResponseEntity.ok(reporteService.generarReporteInventario());
    }
}