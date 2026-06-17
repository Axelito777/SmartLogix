package com.smartlogix.ms_envios.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias de la entidad {@link Envio}.
 *
 * @author SmartLogix Team
 */
class EnvioModelTest {

    @Test
    void settersGetters_cubrenTodosLosCampos() {
        Envio e = new Envio();
        LocalDateTime ahora = LocalDateTime.now();
        e.setId(1L);
        e.setPedidoId("ped-1");
        e.setTrackingNumber("TRK123");
        e.setEstado("ENVIADO");
        e.setTransportista("DHL");
        e.setFechaCreacion(ahora);
        e.setFechaActualizacion(ahora);

        assertEquals(1L, e.getId());
        assertEquals("ped-1", e.getPedidoId());
        assertEquals("TRK123", e.getTrackingNumber());
        assertEquals("ENVIADO", e.getEstado());
        assertEquals("DHL", e.getTransportista());
        assertEquals(ahora, e.getFechaCreacion());
        assertEquals(ahora, e.getFechaActualizacion());
    }

    @Test
    void equals_mismosDatos_debeSerIgual() {
        Envio e1 = new Envio(); e1.setId(1L); e1.setPedidoId("p");
        Envio e2 = new Envio(); e2.setId(1L); e2.setPedidoId("p");
        assertEquals(e1, e2);
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    void equals_idDistinto_noDebeSerIgual() {
        Envio e1 = new Envio(); e1.setId(1L);
        Envio e2 = new Envio(); e2.setId(2L);
        assertNotEquals(e1, e2);
    }

    @Test
    void equals_null_otroTipo_mismaInstancia() {
        Envio e = new Envio(); e.setId(1L);
        assertNotEquals(e, null);
        assertNotEquals(e, "string");
        assertEquals(e, e);
    }

    @Test
    void toString_noEsNulo() {
        Envio e = new Envio(); e.setEstado("PREPARANDO");
        assertNotNull(e.toString());
    }

    @Test
    void onCreate_asignaFechas() {
        Envio e = new Envio();
        e.onCreate();
        assertNotNull(e.getFechaCreacion());
        assertNotNull(e.getFechaActualizacion());
    }

    @Test
    void onUpdate_actualizaFechaActualizacion() {
        Envio e = new Envio();
        e.onUpdate();
        assertNotNull(e.getFechaActualizacion());
    }

    @Test
    void hashCode_camposNulos_noLanzaExcepcion() {
        Envio e = new Envio();
        assertDoesNotThrow(e::hashCode);
    }
}
