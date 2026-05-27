package com.smartlogix.ms_notificaciones.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class NotificacionResponseTest {
    @Test void constructor_y_getters() {
        LocalDateTime now = LocalDateTime.now();
        NotificacionResponse r = new NotificacionResponse(1L, 5L, "Hola", now);
        assertEquals(1L, r.getId()); assertEquals(5L, r.getUsuarioId()); assertEquals("Hola", r.getMensaje());
    }
    @Test void setters() {
        NotificacionResponse r = new NotificacionResponse(1L, 1L, "A", null);
        r.setId(2L); r.setUsuarioId(9L); r.setMensaje("B"); r.setFechaEnvio(LocalDateTime.now());
        assertEquals(2L, r.getId()); assertEquals(9L, r.getUsuarioId()); assertEquals("B", r.getMensaje());
    }
    @Test void equals_mismosDatos() {
        LocalDateTime now = LocalDateTime.now();
        NotificacionResponse r1 = new NotificacionResponse(1L, 5L, "A", now);
        NotificacionResponse r2 = new NotificacionResponse(1L, 5L, "A", now);
        assertEquals(r1, r2); assertEquals(r1.hashCode(), r2.hashCode());
    }
    @Test void equals_distinto() { assertNotEquals(new NotificacionResponse(1L,1L,"A",null), new NotificacionResponse(2L,1L,"A",null)); }
    @Test void equals_null_otroTipo_mismaInstancia() {
        NotificacionResponse r = new NotificacionResponse(1L,1L,"A",null);
        assertNotEquals(r, null); assertEquals(r, r); assertNotEquals(r, "str");
    }
    @Test void toString_noEsNulo() { assertNotNull(new NotificacionResponse(1L,1L,"A",null).toString()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new NotificacionResponse(null,null,null,null)::hashCode); }
}
