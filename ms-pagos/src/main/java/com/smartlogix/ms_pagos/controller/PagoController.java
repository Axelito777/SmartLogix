package com.smartlogix.ms_pagos.controller;

import com.smartlogix.ms_pagos.dto.PagoRequest;
import com.smartlogix.ms_pagos.dto.PagoResponse;
import com.smartlogix.ms_pagos.service.PagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @PostMapping("/procesar")
    public ResponseEntity<PagoResponse> procesar(@Valid @RequestBody PagoRequest request) {
        return ResponseEntity.ok(pagoService.procesar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.obtener(id));
    }

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<List<PagoResponse>> obtenerPorPedido(@PathVariable Long pedidoId) {
        return ResponseEntity.ok(pagoService.obtenerPorPedido(pedidoId));
    }
}