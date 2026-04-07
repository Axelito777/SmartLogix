package com.smartlogix.ms_envios.controller;

import com.smartlogix.ms_envios.model.Envio;
import com.smartlogix.ms_envios.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    @Autowired
    private EnvioService service;

    // 1. GET /api/envios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Envio> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 2. POST /api/envios/crear
    @PostMapping("/crear")
    public Envio crear(@RequestBody Envio envio) {
        return service.crearEnvio(envio);
    }

    // 3. GET /api/envios/{id}/tracking
    @GetMapping("/{id}/tracking")
    public ResponseEntity<Map<String, String>> obtenerTracking(@PathVariable Long id) {
        String infoTracking = service.obtenerTracking(id);
        if (infoTracking.equals("Envío no encontrado")) {
            return ResponseEntity.notFound().build();
        }
        // Retornamos un JSON simple con la info
        return ResponseEntity.ok(Map.of("tracking_info", infoTracking));
    }
}