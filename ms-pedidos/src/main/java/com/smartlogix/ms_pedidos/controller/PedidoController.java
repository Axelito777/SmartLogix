package com.smartlogix.ms_pedidos.controller;

import com.smartlogix.ms_pedidos.dto.PedidoRequest;
import com.smartlogix.ms_pedidos.dto.PedidoResponse;
import com.smartlogix.ms_pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    // GET /api/pedidos
    @GetMapping
    public ResponseEntity<List<PedidoResponse>> listar() {
        return ResponseEntity.ok(pedidoService.listar());
    }

    // GET /api/pedidos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponse> obtener(
            @PathVariable String id) {
        return ResponseEntity.ok(pedidoService.obtener(id));
    }

    // POST /api/pedidos
    @PostMapping
    public ResponseEntity<PedidoResponse> crear(
            @RequestBody PedidoRequest request) {
        return ResponseEntity.ok(pedidoService.crear(request));
    }

    // PUT /api/pedidos/{id}/estado
    @PutMapping("/{id}/estado")
    public ResponseEntity<PedidoResponse> actualizarEstado(
            @PathVariable String id,
            @RequestParam String estado) {
        return ResponseEntity.ok(
            pedidoService.actualizarEstado(id, estado));
    }
}