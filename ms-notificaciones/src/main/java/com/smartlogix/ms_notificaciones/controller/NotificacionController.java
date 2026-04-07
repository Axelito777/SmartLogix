package com.smartlogix.ms_notificaciones.controller;

import com.smartlogix.ms_notificaciones.model.Notificacion;
import com.smartlogix.ms_notificaciones.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService service;

    // 1. POST /api/notificaciones/enviar
    @PostMapping("/enviar")
    public Notificacion enviar(@RequestBody Notificacion notificacion) {
        return service.enviar(notificacion);
    }

    // 2. GET /api/notificaciones/usuario/{id}
    @GetMapping("/usuario/{id}")
    public List<Notificacion> obtenerPorUsuario(@PathVariable Long id) {
        return service.listarPorUsuario(id);
    }
}