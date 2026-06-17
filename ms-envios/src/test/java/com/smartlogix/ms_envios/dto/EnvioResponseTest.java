package com.smartlogix.ms_envios.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias del DTO {@link EnvioResponse}.
 *
 * @author SmartLogix Team
 */
class EnvioResponseTest {
    @Test void constructor_y_getters() {
        LocalDateTime now = LocalDateTime.now();
        EnvioResponse r = new EnvioResponse(1L, "p1", "TRK1", "ENVIADO", "DHL", now);
        assertEquals(1L, r.getId()); assertEquals("p1", r.getPedidoId());
        assertEquals("TRK1", r.getTrackingNumber()); assertEquals("ENVIADO", r.getEstado());
        assertEquals("DHL", r.getTransportista()); assertEquals(now, r.getFechaCreacion());
    }
    @Test void setters() {
        EnvioResponse r = new EnvioResponse(1L, "p", "t", "e", "tr", null);
        r.setId(2L); r.setPedidoId("p2"); r.setTrackingNumber("t2");
        r.setEstado("PREPARANDO"); r.setTransportista("Chilexpress"); r.setFechaCreacion(LocalDateTime.now());
        assertEquals(2L, r.getId()); assertEquals("p2", r.getPedidoId());
    }
    @Test void equals_mismosDatos() {
        LocalDateTime now = LocalDateTime.now();
        EnvioResponse r1 = new EnvioResponse(1L, "p", "t", "e", "d", now);
        EnvioResponse r2 = new EnvioResponse(1L, "p", "t", "e", "d", now);
        assertEquals(r1, r2); assertEquals(r1.hashCode(), r2.hashCode());
    }
    @Test void equals_distinto() {
        EnvioResponse r1 = new EnvioResponse(1L, "p1", "t", "e", "d", null);
        EnvioResponse r2 = new EnvioResponse(2L, "p2", "t", "e", "d", null);
        assertNotEquals(r1, r2);
    }
    @Test void equals_null_otroTipo_mismaInstancia() {
        EnvioResponse r = new EnvioResponse(1L, "p", "t", "e", "d", null);
        assertNotEquals(r, null); assertEquals(r, r); assertNotEquals(r, "str");
    }
    @Test void toString_noEsNulo() { assertNotNull(new EnvioResponse(1L,"p","t","e","d",null).toString()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new EnvioResponse(null,null,null,null,null,null)::hashCode); }
}
