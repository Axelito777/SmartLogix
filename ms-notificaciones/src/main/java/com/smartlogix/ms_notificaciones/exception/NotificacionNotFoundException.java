package com.smartlogix.ms_notificaciones.exception;

public class NotificacionNotFoundException extends RuntimeException {
    public NotificacionNotFoundException(Long id) {
        super("Notificación no encontrada con id: " + id);
    }
}