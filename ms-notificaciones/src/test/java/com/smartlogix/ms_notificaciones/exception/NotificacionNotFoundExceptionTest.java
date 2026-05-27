package com.smartlogix.ms_notificaciones.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificacionNotFoundExceptionTest {
    @Test void constructor_mensajeContieneId() {
        NotificacionNotFoundException ex = new NotificacionNotFoundException(3L);
        assertTrue(ex.getMessage().contains("3"));
        assertInstanceOf(RuntimeException.class, ex);
    }
}
