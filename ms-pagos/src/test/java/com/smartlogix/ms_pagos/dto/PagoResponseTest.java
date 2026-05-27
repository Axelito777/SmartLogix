package com.smartlogix.ms_pagos.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PagoResponseTest {
    @Test void constructor_y_getters() {
        PagoResponse r = new PagoResponse(1L, 100L, 50000.0, "PROCESADO", "TARJETA");
        assertEquals(1L, r.getId()); assertEquals(100L, r.getPedidoId());
        assertEquals(50000.0, r.getMonto()); assertEquals("PROCESADO", r.getEstado());
        assertEquals("TARJETA", r.getMetodoPago());
    }
    @Test void setters() {
        PagoResponse r = new PagoResponse(1L, 1L, 1.0, "s", "m");
        r.setId(2L); r.setPedidoId(200L); r.setMonto(9000.0); r.setEstado("REVERTIDO"); r.setMetodoPago("EFECTIVO");
        assertEquals(2L, r.getId()); assertEquals(200L, r.getPedidoId()); assertEquals(9000.0, r.getMonto());
    }
    @Test void equals_mismosDatos() {
        PagoResponse r1 = new PagoResponse(1L, 1L, 100.0, "PROCESADO", "T");
        PagoResponse r2 = new PagoResponse(1L, 1L, 100.0, "PROCESADO", "T");
        assertEquals(r1, r2); assertEquals(r1.hashCode(), r2.hashCode());
    }
    @Test void equals_distinto() {
        assertNotEquals(new PagoResponse(1L,1L,1.0,"a","b"), new PagoResponse(2L,1L,1.0,"a","b"));
    }
    @Test void equals_null_otroTipo_mismaInstancia() {
        PagoResponse r = new PagoResponse(1L,1L,1.0,"a","b");
        assertNotEquals(r, null); assertEquals(r, r); assertNotEquals(r, "str");
    }
    @Test void toString_noEsNulo() { assertNotNull(new PagoResponse(1L,1L,1.0,"a","b").toString()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new PagoResponse(null,null,null,null,null)::hashCode); }
}
