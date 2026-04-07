package com.smartlogix.ms_notificaciones.repository;

import com.smartlogix.ms_notificaciones.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    // Para cumplir con el endpoint de listar por usuario
    List<Notificacion> findByUsuarioId(Long usuarioId);
}