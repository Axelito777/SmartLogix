package com.smartlogix.ms_reportes.client;

import com.smartlogix.ms_reportes.dto.PedidoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * Cliente Feign para obtener el listado de pedidos desde el
 * microservicio ms-pedidos, usado para generar reportes de ventas.
 *
 * @author SmartLogix Team
 */
@FeignClient(name = "ms-pedidos")
public interface PedidosClient {

    /**
     * Obtiene el listado completo de pedidos.
     *
     * @return lista de pedidos
     */
    @GetMapping("/api/pedidos")
    List<PedidoDTO> getPedidos();
}
