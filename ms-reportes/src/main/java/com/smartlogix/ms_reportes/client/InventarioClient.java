package com.smartlogix.ms_reportes.client;

import com.smartlogix.ms_reportes.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "ms-inventario")
public interface InventarioClient {

    @GetMapping("/api/inventario/productos")
    List<ProductoDTO> getProductos();
}