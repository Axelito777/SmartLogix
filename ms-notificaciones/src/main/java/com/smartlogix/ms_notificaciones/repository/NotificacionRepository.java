package com.smartlogix.ms_notificaciones.repository;

import com.smartlogix.ms_notificaciones.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio JPA para la entidad {@link com.smartlogix.ms_notificaciones.model.Notificacion}.
 * <p>
 * Hereda operaciones CRUD de {@link JpaRepository} y añade búsqueda por usuario.
 * </p>
 *
 * @author SmartLogix Team
 */
@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    /**
     * Busca todas las notificaciones de un usuario específico.
     *
     * @param usuarioId identificador numérico del usuario
     * @return lista de notificaciones del usuario; vacía si no tiene ninguna
     */
    List<Notificacion> findByUsuarioId(Long usuarioId);
}