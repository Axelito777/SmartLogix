package com.smartlogix.ms_notificaciones.service;

import com.smartlogix.ms_notificaciones.dto.NotificacionRequest;
import com.smartlogix.ms_notificaciones.dto.NotificacionResponse;
import com.smartlogix.ms_notificaciones.model.Notificacion;
import com.smartlogix.ms_notificaciones.repository.NotificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio de negocio para la gestión de notificaciones.
 * <p>
 * Persiste las notificaciones enviadas por otros microservicios y las expone
 * para consulta global o por usuario.
 * </p>
 *
 * @author SmartLogix Team
 */
@Service
@RequiredArgsConstructor
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;

    /**
     * Crea y persiste una nueva notificación para el usuario indicado.
     *
     * @param request DTO con el {@code usuarioId} y el {@code mensaje}
     * @return {@link NotificacionResponse} con los datos de la notificación guardada
     */
    public NotificacionResponse enviar(NotificacionRequest request) {
        Notificacion n = new Notificacion();
        n.setUsuarioId(request.getUsuarioId());
        n.setMensaje(request.getMensaje());
        notificacionRepository.save(n);
        return convertirAResponse(n);
    }

    /**
     * Obtiene todas las notificaciones asociadas a un usuario.
     *
     * @param usuarioId identificador numérico del usuario
     * @return lista de {@link NotificacionResponse} del usuario; vacía si no tiene notificaciones
     */
    public List<NotificacionResponse> obtenerPorUsuario(Long usuarioId) {
        return notificacionRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    /**
     * Retorna todas las notificaciones del sistema.
     *
     * @return lista de {@link NotificacionResponse}; vacía si no hay notificaciones
     */
    public List<NotificacionResponse> listar() {
        return notificacionRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    private NotificacionResponse convertirAResponse(Notificacion n) {
        return new NotificacionResponse(n.getId(), n.getUsuarioId(), n.getMensaje(), n.getFechaEnvio());
    }
}