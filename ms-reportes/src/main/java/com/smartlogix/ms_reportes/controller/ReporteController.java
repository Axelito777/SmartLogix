package com.smartlogix.ms_reportes.controller;

import com.smartlogix.ms_reportes.dto.ReporteInventarioDTO;
import com.smartlogix.ms_reportes.dto.ReporteVentasDTO;
import com.smartlogix.ms_reportes.service.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    @GetMapping("/ventas")
    public ResponseEntity<ReporteVentasDTO> reporteVentas() {
        return ResponseEntity.ok(reporteService.generarReporteVentas());
    }

    @GetMapping("/inventario")
    public ResponseEntity<ReporteInventarioDTO> reporteInventario() {
        return ResponseEntity.ok(reporteService.generarReporteInventario());
    }
}