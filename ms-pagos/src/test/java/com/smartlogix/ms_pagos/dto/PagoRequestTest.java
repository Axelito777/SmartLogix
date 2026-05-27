package com.smartlogix.ms_pagos.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PagoRequestTest {
    @Test void gettersSetters() {
        PagoRequest r = new PagoRequest();
        r.setPedidoId(1L); r.setMonto(5000.0); r.setMetodoPago("TARJETA");
        assertEquals(1L, r.getPedidoId()); assertEquals(5000.0, r.getMonto());
        assertEquals("TARJETA", r.getMetodoPago());
    }
    @Test void equals_mismosDatos() {
        PagoRequest r1 = new PagoRequest(); r1.setPedidoId(1L); r1.setMonto(100.0); r1.setMetodoPago("EFECTIVO");
        PagoRequest r2 = new PagoRequest(); r2.setPedidoId(1L); r2.setMonto(100.0); r2.setMetodoPago("EFECTIVO");
        assertEquals(r1, r2); assertEquals(r1.hashCode(), r2.hashCode());
    }
    @Test void equals_distinto() {
        PagoRequest r1 = new PagoRequest(); r1.setPedidoId(1L);
        PagoRequest r2 = new PagoRequest(); r2.setPedidoId(2L);
        assertNotEquals(r1, r2);
    }
    @Test void equals_null_otroTipo_mismaInstancia() {
        PagoRequest r = new PagoRequest();
        assertNotEquals(r, null); assertEquals(r, r); assertNotEquals(r, "str");
    }
    @Test void toString_noEsNulo() { assertNotNull(new PagoRequest().toString()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new PagoRequest()::hashCode); }
}
