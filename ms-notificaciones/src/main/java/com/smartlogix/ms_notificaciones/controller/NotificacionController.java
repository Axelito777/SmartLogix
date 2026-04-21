package com.smartlogix.ms_notificaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartlogix.ms_notificaciones.entity.Notificacion;
import com.smartlogix.ms_notificaciones.repository.NotificacionRepository;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionRepository repository;

    // 1. POST /api/notificaciones/enviar
    @PostMapping("/enviar")
    public Notificacion enviarNotificacion(@RequestBody Notificacion notificacion) {
        return repository.save(notificacion);
    }

    // 2. GET /api/notificaciones/usuario/{id}
    @GetMapping("/usuario/{id}")
    public List<Notificacion> obtenerPorUsuario(@PathVariable Long id) {
        return repository.findByUsuarioId(id);
    }
}