package com.smartlogix.ms_inventario.controller;

import com.smartlogix.ms_inventario.dto.ProductoRequest;
import com.smartlogix.ms_inventario.dto.ProductoResponse;
import com.smartlogix.ms_inventario.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    // GET /api/inventario/productos
    @GetMapping("/productos")
    public ResponseEntity<List<ProductoResponse>> listar() {
        return ResponseEntity.ok(productoService.listar());
    }

    // GET /api/inventario/productos/{id}
    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoResponse> obtener(
            @PathVariable String id) {
        return ResponseEntity.ok(productoService.obtener(id));
    }

    // POST /api/inventario/productos
    @PostMapping("/productos")
    public ResponseEntity<ProductoResponse> crear(
            @RequestBody ProductoRequest request) {
        return ResponseEntity.ok(productoService.crear(request));
    }

    // PUT /api/inventario/productos/{id}/stock
    @PutMapping("/productos/{id}/stock")
    public ResponseEntity<ProductoResponse> actualizarStock(
            @PathVariable String id,
            @RequestParam Integer cantidad) {
        return ResponseEntity.ok(
            productoService.actualizarStock(id, cantidad));
    }

    // GET /api/inventario/productos/bajo-stock
    @GetMapping("/productos/bajo-stock")
    public ResponseEntity<List<ProductoResponse>> bajoStock() {
        return ResponseEntity.ok(productoService.bajoStock());
    }
}
