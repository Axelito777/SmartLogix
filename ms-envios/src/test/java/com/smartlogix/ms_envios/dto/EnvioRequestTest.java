package com.smartlogix.ms_envios.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnvioRequestTest {
    @Test void gettersSetters() {
        EnvioRequest r = new EnvioRequest();
        r.setPedidoId("p1"); r.setTransportista("DHL");
        assertEquals("p1", r.getPedidoId());
        assertEquals("DHL", r.getTransportista());
    }
    @Test void equals_mismosDatos() {
        EnvioRequest r1 = new EnvioRequest(); r1.setPedidoId("p1"); r1.setTransportista("DHL");
        EnvioRequest r2 = new EnvioRequest(); r2.setPedidoId("p1"); r2.setTransportista("DHL");
        assertEquals(r1, r2); assertEquals(r1.hashCode(), r2.hashCode());
    }
    @Test void equals_distinto() {
        EnvioRequest r1 = new EnvioRequest(); r1.setPedidoId("p1");
        EnvioRequest r2 = new EnvioRequest(); r2.setPedidoId("p2");
        assertNotEquals(r1, r2);
    }
    @Test void equals_null_mismaInstancia_otroTipo() {
        EnvioRequest r = new EnvioRequest(); r.setPedidoId("p1");
        assertNotEquals(r, null); assertEquals(r, r); assertNotEquals(r, "str");
    }
    @Test void toString_noEsNulo() { assertNotNull(new EnvioRequest().toString()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new EnvioRequest()::hashCode); }
}
