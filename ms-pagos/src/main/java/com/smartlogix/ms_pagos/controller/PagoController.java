package com.smartlogix.ms_pagos.controller;

import com.smartlogix.ms_pagos.model.Pago;
import com.smartlogix.ms_pagos.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService service;

    // 1. POST /api/pagos/procesar
    @PostMapping("/procesar")
    public Pago procesar(@RequestBody Pago pago) {
        return service.procesarPago(pago);
    }

    // 2. GET /api/pagos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. GET /api/pagos/pedido/{pedidoId}
    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<Pago> obtenerPorPedido(@PathVariable Long pedidoId) {
        return service.obtenerPorPedidoId(pedidoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}