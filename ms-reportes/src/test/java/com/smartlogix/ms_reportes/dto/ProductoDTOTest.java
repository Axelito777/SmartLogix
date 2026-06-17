package com.smartlogix.ms_reportes.dto;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias del DTO {@link ProductoDTO}.
 *
 * @author SmartLogix Team
 */
class ProductoDTOTest {
    @Test void gettersSetters() {
        ProductoDTO p = new ProductoDTO();
        p.setId("1"); p.setNombre("Tornillo"); p.setPrecio(BigDecimal.TEN); p.setStock(50); p.setStockMinimo(5);
        assertEquals("1", p.getId()); assertEquals("Tornillo", p.getNombre()); assertEquals(BigDecimal.TEN, p.getPrecio());
        assertEquals(50, p.getStock()); assertEquals(5, p.getStockMinimo());
    }
    @Test void equals_mismosDatos() {
        ProductoDTO p1 = new ProductoDTO(); p1.setId("1"); p1.setNombre("A");
        ProductoDTO p2 = new ProductoDTO(); p2.setId("1"); p2.setNombre("A");
        assertEquals(p1, p2); assertEquals(p1.hashCode(), p2.hashCode());
    }
    @Test void equals_distinto() {
        ProductoDTO p1 = new ProductoDTO(); p1.setId("1");
        ProductoDTO p2 = new ProductoDTO(); p2.setId("2");
        assertNotEquals(p1, p2);
    }
    @Test void equals_null_otroTipo_mismaInstancia() {
        ProductoDTO p = new ProductoDTO();
        assertNotEquals(p, null); assertEquals(p, p); assertNotEquals(p, "str");
    }
    @Test void toString_noEsNulo() { assertNotNull(new ProductoDTO().toString()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new ProductoDTO()::hashCode); }
}
