package com.smartlogix.ms_pagos.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias de la entidad {@link Pago}.
 *
 * @author SmartLogix Team
 */
class PagoModelTest {
    @Test void settersGetters() {
        Pago p = new Pago();
        p.setId(1L); p.setPedidoId(100L); p.setMonto(50000.0);
        p.setEstado("PROCESADO"); p.setMetodoPago("TARJETA");
        assertEquals(1L, p.getId()); assertEquals(100L, p.getPedidoId());
        assertEquals(50000.0, p.getMonto()); assertEquals("PROCESADO", p.getEstado());
        assertEquals("TARJETA", p.getMetodoPago());
    }
    @Test void equals_mismosDatos() {
        Pago p1 = new Pago(); p1.setId(1L); p1.setPedidoId(1L); p1.setMonto(100.0);
        Pago p2 = new Pago(); p2.setId(1L); p2.setPedidoId(1L); p2.setMonto(100.0);
        assertEquals(p1, p2); assertEquals(p1.hashCode(), p2.hashCode());
    }
    @Test void equals_distinto() {
        Pago p1 = new Pago(); p1.setId(1L);
        Pago p2 = new Pago(); p2.setId(2L);
        assertNotEquals(p1, p2);
    }
    @Test void equals_null_otroTipo_mismaInstancia() {
        Pago p = new Pago(); p.setId(1L);
        assertNotEquals(p, null); assertEquals(p, p); assertNotEquals(p, "str");
    }
    @Test void toString_noEsNulo() { assertNotNull(new Pago().toString()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new Pago()::hashCode); }
}
