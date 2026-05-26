package com.smartlogix.ms_proveedores.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class ProveedorModelTest {
    @Test void settersGetters() {
        Proveedor p = new Proveedor();
        LocalDateTime now = LocalDateTime.now();
        p.setId(1L); p.setNombre("Prov S.A."); p.setEmail("e@t.cl");
        p.setTelefono("+569"); p.setDireccion("Calle 1");
        p.setCreatedAt(now); p.setUpdatedAt(now);
        assertEquals(1L, p.getId()); assertEquals("Prov S.A.", p.getNombre());
        assertEquals("e@t.cl", p.getEmail()); assertEquals("+569", p.getTelefono());
        assertEquals("Calle 1", p.getDireccion()); assertEquals(now, p.getCreatedAt());
    }
    @Test void equals_mismosDatos() {
        Proveedor p1 = new Proveedor(); p1.setId(1L); p1.setNombre("A");
        Proveedor p2 = new Proveedor(); p2.setId(1L); p2.setNombre("A");
        assertEquals(p1, p2); assertEquals(p1.hashCode(), p2.hashCode());
    }
    @Test void equals_distinto() {
        Proveedor p1 = new Proveedor(); p1.setId(1L);
        Proveedor p2 = new Proveedor(); p2.setId(2L);
        assertNotEquals(p1, p2);
    }
    @Test void equals_null_otroTipo_mismaInstancia() {
        Proveedor p = new Proveedor(); p.setId(1L);
        assertNotEquals(p, null); assertEquals(p, p); assertNotEquals(p, "str");
    }
    @Test void toString_contieneNombre() { Proveedor p = new Proveedor(); p.setNombre("Test"); assertTrue(p.toString().contains("Test")); }
    @Test void onCreate_asignaFechas() { Proveedor p = new Proveedor(); p.onCreate(); assertNotNull(p.getCreatedAt()); assertNotNull(p.getUpdatedAt()); }
    @Test void onUpdate_actualizaFecha() { Proveedor p = new Proveedor(); p.onUpdate(); assertNotNull(p.getUpdatedAt()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new Proveedor()::hashCode); }
}
