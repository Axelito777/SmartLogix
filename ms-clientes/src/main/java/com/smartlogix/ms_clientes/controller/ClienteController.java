package com.smartlogix.ms_clientes.controller;

import com.smartlogix.ms_clientes.dto.ClienteRequest;
import com.smartlogix.ms_clientes.dto.ClienteResponse;
import com.smartlogix.ms_clientes.dto.PedidoResponse;
import com.smartlogix.ms_clientes.service.ClienteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    // GET /api/clientes
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar() {
        return ResponseEntity.ok(clienteService.listar());
    }

    // GET /api/clientes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> obtener(
            @PathVariable String id) {
        return ResponseEntity.ok(clienteService.obtener(id));
    }

    // POST /api/clientes
    @PostMapping
    public ResponseEntity<ClienteResponse> crear(
            @Valid @RequestBody ClienteRequest request) { // Agregado @Valid aquí
        return ResponseEntity.ok(clienteService.crear(request));
    }

    // PUT /api/clientes/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizar(
            @PathVariable String id,
            @Valid @RequestBody ClienteRequest request) { // Agregado @Valid aquí
        return ResponseEntity.ok(
            clienteService.actualizar(id, request));
    }
    
    @GetMapping("/{id}/pedidos")
    public ResponseEntity<List<PedidoResponse>> getPedidos(@PathVariable String id) {
        return ResponseEntity.ok(clienteService.getPedidosByCliente(id));
    }
}