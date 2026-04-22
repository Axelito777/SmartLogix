package com.smartlogix.ms_notificaciones.controller;

import java.util.List;

import com.smartlogix.ms_notificaciones.dto.NotificacionRequest;
import com.smartlogix.ms_notificaciones.dto.NotificacionResponse;
import com.smartlogix.ms_notificaciones.service.NotificacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {

    private final NotificacionService notificacionService;

    @PostMapping("/enviar")
    public ResponseEntity<NotificacionResponse> enviar(@Valid @RequestBody NotificacionRequest request) {
        return ResponseEntity.ok(notificacionService.enviar(request));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<NotificacionResponse>> obtenerPorUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(notificacionService.obtenerPorUsuario(id));
    }
}