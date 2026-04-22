package com.smartlogix.ms_notificaciones.service;

import com.smartlogix.ms_notificaciones.dto.NotificacionRequest;
import com.smartlogix.ms_notificaciones.dto.NotificacionResponse;
import com.smartlogix.ms_notificaciones.model.Notificacion;
import com.smartlogix.ms_notificaciones.repository.NotificacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;

    public NotificacionResponse enviar(NotificacionRequest request) {
        Notificacion n = new Notificacion();
        n.setUsuarioId(request.getUsuarioId());
        n.setMensaje(request.getMensaje());
        notificacionRepository.save(n);
        return convertirAResponse(n);
    }

    public List<NotificacionResponse> obtenerPorUsuario(Long usuarioId) {
        return notificacionRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    private NotificacionResponse convertirAResponse(Notificacion n) {
        return new NotificacionResponse(n.getId(), n.getUsuarioId(), n.getMensaje(), n.getFechaEnvio());
    }
}