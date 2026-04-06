package com.smartlogix.ms_pedidos.client;

import com.smartlogix.ms_pedidos.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-inventario")
public interface InventarioClient {

    @GetMapping("/api/inventario/productos/{id}")
    ProductoDTO getProductoById(@PathVariable String id);

    @PutMapping("/api/inventario/productos/{id}/stock")
    void actualizarStock(@PathVariable String id, @RequestBody Integer cantidad);
}