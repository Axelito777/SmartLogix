package com.smartlogix.ms_reportes.client;

import com.smartlogix.ms_reportes.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * Cliente Feign para obtener el listado de productos desde el
 * microservicio ms-inventario, usado para generar reportes de inventario.
 *
 * @author SmartLogix Team
 */
@FeignClient(name = "ms-inventario")
public interface InventarioClient {

    /**
     * Obtiene el listado completo de productos del inventario.
     *
     * @return lista de productos
     */
    @GetMapping("/api/inventario/productos")
    List<ProductoDTO> getProductos();
}