package com.smartlogix.ms_pedidos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@FeignClient(name = "ms-envios")
public interface EnviosClient {

    @PostMapping("/api/envios/crear")
    void crearEnvio(@RequestBody Map<String, Object> envio);
}
