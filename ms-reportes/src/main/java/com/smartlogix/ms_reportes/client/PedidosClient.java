package com.smartlogix.ms_reportes.client;

import com.smartlogix.ms_reportes.dto.PedidoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "ms-pedidos")
public interface PedidosClient {

    @GetMapping("/api/pedidos")
    List<PedidoDTO> getPedidos();
}
