package com.smartlogix.ms_pagos.controller;

import com.smartlogix.ms_pagos.dto.PagoRequest;
import com.smartlogix.ms_pagos.dto.PagoResponse;
import com.smartlogix.ms_pagos.service.PagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para el procesamiento y consulta de pagos.
 * <p>
 * Expone endpoints para procesar pagos y consultarlos por id o pedido
 * bajo la ruta base {@code /api/pagos}.
 * </p>
 *
 * @author SmartLogix Team
 */
@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    /**
     * Procesa un pago asociado a un pedido.
     *
     * @param request datos del pago con {@code pedidoId}, {@code monto} y {@code metodoPago}
     * @return {@code 200 OK} con el {@link PagoResponse} del pago procesado en estado {@code PROCESADO}
     */
    @PostMapping("/procesar")
    public ResponseEntity<PagoResponse> procesar(@Valid @RequestBody PagoRequest request) {
        return ResponseEntity.ok(pagoService.procesar(request));
    }

    /**
     * Obtiene un pago por su identificador.
     *
     * @param id identificador numérico del pago
     * @return {@code 200 OK} con el {@link PagoResponse} encontrado
     * @throws com.smartlogix.ms_pagos.exception.PagoNotFoundException si no existe el pago
     */
    @GetMapping("/{id}")
    public ResponseEntity<PagoResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.obtener(id));
    }

    /**
     * Retorna todos los pagos asociados a un pedido.
     *
     * @param pedidoId identificador numérico del pedido
     * @return {@code 200 OK} con la lista de {@link PagoResponse} del pedido
     */
    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<List<PagoResponse>> obtenerPorPedido(@PathVariable Long pedidoId) {
        return ResponseEntity.ok(pagoService.obtenerPorPedido(pedidoId));
    }

    /**
     * Retorna la lista completa de pagos registrados.
     *
     * @return {@code 200 OK} con todos los {@link PagoResponse}
     */
    @GetMapping
    public ResponseEntity<List<PagoResponse>> listar() {
        return ResponseEntity.ok(pagoService.listar());
    }
}