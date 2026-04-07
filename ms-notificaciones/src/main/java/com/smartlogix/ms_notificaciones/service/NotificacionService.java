package com.smartlogix.ms_notificaciones.service;

import com.smartlogix.ms_notificaciones.model.Notificacion;
import com.smartlogix.ms_notificaciones.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository repository;

    public Notificacion enviar(Notificacion notificacion) {
        notificacion.setFechaEnvio(LocalDateTime.now());
        // Aquí iría la lógica real de envío (JavaMailSender, etc.)
        return repository.save(notificacion);
    }

    public List<Notificacion> listarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
}