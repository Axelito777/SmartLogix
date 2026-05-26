package com.smartlogix.ms_proveedores.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class ProveedorResponseTest {
    @Test void constructor_y_getters() {
        LocalDateTime now = LocalDateTime.now();
        ProveedorResponse r = new ProveedorResponse(1L, "Prov", "e@t.cl", "+569", "Calle 1", now);
        assertEquals(1L, r.getId()); assertEquals("Prov", r.getNombre()); assertEquals("e@t.cl", r.getEmail());
    }
    @Test void setters() {
        ProveedorResponse r = new ProveedorResponse(1L,"a","b","c","d",null);
        r.setId(2L); r.setNombre("X"); r.setEmail("x@x.com"); r.setTelefono("123"); r.setDireccion("X"); r.setCreatedAt(LocalDateTime.now());
        assertEquals(2L, r.getId()); assertEquals("X", r.getNombre());
    }
    @Test void equals_mismosDatos() {
        LocalDateTime now = LocalDateTime.now();
        ProveedorResponse r1 = new ProveedorResponse(1L,"a","b","c","d",now);
        ProveedorResponse r2 = new ProveedorResponse(1L,"a","b","c","d",now);
        assertEquals(r1, r2); assertEquals(r1.hashCode(), r2.hashCode());
    }
    @Test void equals_distinto() {
        assertNotEquals(new ProveedorResponse(1L,"a","b","c","d",null), new ProveedorResponse(2L,"a","b","c","d",null));
    }
    @Test void equals_null_otroTipo_mismaInstancia() {
        ProveedorResponse r = new ProveedorResponse(1L,"a","b","c","d",null);
        assertNotEquals(r, null); assertEquals(r, r); assertNotEquals(r, "str");
    }
    @Test void toString_noEsNulo() { assertNotNull(new ProveedorResponse(1L,"a","b","c","d",null).toString()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new ProveedorResponse(null,null,null,null,null,null)::hashCode); }
}
