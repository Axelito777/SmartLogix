package com.smartlogix.ms_notificaciones.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class NotificacionModelTest {
    @Test void settersGetters() {
        Notificacion n = new Notificacion();
        LocalDateTime now = LocalDateTime.now();
        n.setId(1L); n.setUsuarioId(10L); n.setMensaje("Hola"); n.setFechaEnvio(now);
        assertEquals(1L, n.getId()); assertEquals(10L, n.getUsuarioId());
        assertEquals("Hola", n.getMensaje()); assertEquals(now, n.getFechaEnvio());
    }
    @Test void equals_mismosDatos() {
        Notificacion n1 = new Notificacion(); n1.setId(1L); n1.setMensaje("A");
        Notificacion n2 = new Notificacion(); n2.setId(1L); n2.setMensaje("A");
        assertEquals(n1, n2); assertEquals(n1.hashCode(), n2.hashCode());
    }
    @Test void equals_distinto() {
        Notificacion n1 = new Notificacion(); n1.setId(1L);
        Notificacion n2 = new Notificacion(); n2.setId(2L);
        assertNotEquals(n1, n2);
    }
    @Test void equals_null_otroTipo_mismaInstancia() {
        Notificacion n = new Notificacion(); n.setId(1L);
        assertNotEquals(n, null); assertEquals(n, n); assertNotEquals(n, "str");
    }
    @Test void toString_noEsNulo() { Notificacion n = new Notificacion(); n.setMensaje("Test"); assertNotNull(n.toString()); }
    @Test void onCreate_asignaFechaEnvio() { Notificacion n = new Notificacion(); n.onCreate(); assertNotNull(n.getFechaEnvio()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new Notificacion()::hashCode); }
}
