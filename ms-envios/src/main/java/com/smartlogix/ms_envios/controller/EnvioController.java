package com.smartlogix.ms_envios.controller;

import com.smartlogix.ms_envios.dto.EnvioRequest;
import com.smartlogix.ms_envios.dto.EnvioResponse;
import com.smartlogix.ms_envios.service.EnvioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/envios")
@RequiredArgsConstructor
public class EnvioController {

    private final EnvioService envioService;

    @PostMapping("/crear")
    public ResponseEntity<EnvioResponse> crear(@RequestBody Map<String, Object> body) {
        EnvioRequest request = new EnvioRequest();
        request.setPedidoId(Long.valueOf(body.get("pedido_id").toString()));
        if (body.get("transportista") != null) {
            request.setTransportista(body.get("transportista").toString());
        }
        return ResponseEntity.ok(envioService.crear(request));
    }

    @GetMapping
    public ResponseEntity<List<EnvioResponse>> listar() {
        return ResponseEntity.ok(envioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvioResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(envioService.obtener(id));
    }
}