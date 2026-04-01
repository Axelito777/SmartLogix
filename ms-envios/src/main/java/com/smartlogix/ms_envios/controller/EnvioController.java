package com.smartlogix.ms_envios.controller;

import com.smartlogix.ms_envios.entity.Envio;
import com.smartlogix.ms_envios.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envios") // Esta es la URL base de este microservicio
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    // POST: Para crear un nuevo envío (ej. cuando se confirma un pedido)
    @PostMapping
    public ResponseEntity<Envio> crearEnvio(@RequestBody Envio envio) {
        Envio nuevoEnvio = envioService.crearEnvio(envio);
        return ResponseEntity.ok(nuevoEnvio);
    }

    // GET: Para ver todos loss envíos y su estado de tracking
    @GetMapping
    public ResponseEntity<List<Envio>> obtenerEnvios() {
        return ResponseEntity.ok(envioService.obtenerTodos());
    }
}