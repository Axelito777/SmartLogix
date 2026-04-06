package com.smartlogix.ms_pedidos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@FeignClient(name = "ms-pagos")
public interface PagosClient {

    @PostMapping("/api/pagos/procesar")
    void procesarPago(@RequestBody Map<String, Object> pago);
}