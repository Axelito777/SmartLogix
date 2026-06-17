package com.smartlogix.ms_notificaciones.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias del DTO {@link NotificacionRequest}.
 *
 * @author SmartLogix Team
 */
class NotificacionRequestTest {
    @Test void gettersSetters() {
        NotificacionRequest r = new NotificacionRequest();
        r.setUsuarioId(5L); r.setMensaje("Hola");
        assertEquals(5L, r.getUsuarioId()); assertEquals("Hola", r.getMensaje());
    }
    @Test void equals_mismosDatos() {
        NotificacionRequest r1 = new NotificacionRequest(); r1.setUsuarioId(1L); r1.setMensaje("A");
        NotificacionRequest r2 = new NotificacionRequest(); r2.setUsuarioId(1L); r2.setMensaje("A");
        assertEquals(r1, r2); assertEquals(r1.hashCode(), r2.hashCode());
    }
    @Test void equals_distinto() {
        NotificacionRequest r1 = new NotificacionRequest(); r1.setUsuarioId(1L);
        NotificacionRequest r2 = new NotificacionRequest(); r2.setUsuarioId(2L);
        assertNotEquals(r1, r2);
    }
    @Test void equals_null_otroTipo_mismaInstancia() {
        NotificacionRequest r = new NotificacionRequest();
        assertNotEquals(r, null); assertEquals(r, r); assertNotEquals(r, "str");
    }
    @Test void toString_noEsNulo() { assertNotNull(new NotificacionRequest().toString()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new NotificacionRequest()::hashCode); }
}
