package com.smartlogix.ms_envios.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@FeignClient(name = "ms-notificaciones")
public interface NotificacionesClient {

    @PostMapping("/api/notificaciones/enviar")
    void enviarNotificacion(@RequestBody Map<String, Object> notificacion);
}
