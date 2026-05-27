package com.smartlogix.ms_notificaciones.controller;

import java.util.List;

import com.smartlogix.ms_notificaciones.dto.NotificacionRequest;
import com.smartlogix.ms_notificaciones.dto.NotificacionResponse;
import com.smartlogix.ms_notificaciones.service.NotificacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de notificaciones.
 * <p>
 * Expone endpoints para enviar notificaciones y consultarlas por usuario
 * bajo la ruta base {@code /api/notificaciones}.
 * </p>
 *
 * @author SmartLogix Team
 */
@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {

    private final NotificacionService notificacionService;

    /**
     * Persiste y devuelve una nueva notificación para un usuario.
     *
     * @param request datos de la notificación con {@code usuarioId} y {@code mensaje}
     * @return {@code 200 OK} con el {@link NotificacionResponse} registrado
     */
    @PostMapping("/enviar")
    public ResponseEntity<NotificacionResponse> enviar(@Valid @RequestBody NotificacionRequest request) {
        return ResponseEntity.ok(notificacionService.enviar(request));
    }

    /**
     * Retorna todas las notificaciones de un usuario específico.
     *
     * @param id identificador numérico del usuario
     * @return {@code 200 OK} con la lista de {@link NotificacionResponse} del usuario
     */
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<NotificacionResponse>> obtenerPorUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(notificacionService.obtenerPorUsuario(id));
    }

    /**
     * Retorna la lista completa de notificaciones del sistema.
     *
     * @return {@code 200 OK} con todas las {@link NotificacionResponse}
     */
    @GetMapping
    public ResponseEntity<List<NotificacionResponse>> listar() {
        return ResponseEntity.ok(notificacionService.listar());
    }
}