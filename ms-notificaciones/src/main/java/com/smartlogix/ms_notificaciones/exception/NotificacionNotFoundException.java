package com.smartlogix.ms_notificaciones.exception;

/**
 * Excepción lanzada cuando no se encuentra una notificación con el id solicitado.
 *
 * @author SmartLogix Team
 */
public class NotificacionNotFoundException extends RuntimeException {
    /**
     * Crea la excepción con un mensaje que incluye el id de la notificación buscada.
     *
     * @param id identificador de la notificación que no fue encontrada
     */
    public NotificacionNotFoundException(Long id) {
        super("Notificación no encontrada con id: " + id);
    }
}