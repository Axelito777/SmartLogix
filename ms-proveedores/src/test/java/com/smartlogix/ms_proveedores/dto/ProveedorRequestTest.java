package com.smartlogix.ms_proveedores.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias del DTO {@link ProveedorRequest}.
 *
 * @author SmartLogix Team
 */
class ProveedorRequestTest {
    @Test void gettersSetters() {
        ProveedorRequest r = new ProveedorRequest();
        r.setNombre("Prov"); r.setEmail("e@t.cl"); r.setTelefono("+569"); r.setDireccion("Calle 1");
        assertEquals("Prov", r.getNombre()); assertEquals("e@t.cl", r.getEmail());
        assertEquals("+569", r.getTelefono()); assertEquals("Calle 1", r.getDireccion());
    }
    @Test void equals_mismosDatos() {
        ProveedorRequest r1 = new ProveedorRequest(); r1.setNombre("A"); r1.setEmail("a@b.com");
        ProveedorRequest r2 = new ProveedorRequest(); r2.setNombre("A"); r2.setEmail("a@b.com");
        assertEquals(r1, r2); assertEquals(r1.hashCode(), r2.hashCode());
    }
    @Test void equals_distinto() {
        ProveedorRequest r1 = new ProveedorRequest(); r1.setNombre("A");
        ProveedorRequest r2 = new ProveedorRequest(); r2.setNombre("B");
        assertNotEquals(r1, r2);
    }
    @Test void equals_null_otroTipo_mismaInstancia() {
        ProveedorRequest r = new ProveedorRequest();
        assertNotEquals(r, null); assertEquals(r, r); assertNotEquals(r, "str");
    }
    @Test void toString_noEsNulo() { assertNotNull(new ProveedorRequest().toString()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new ProveedorRequest()::hashCode); }
}
