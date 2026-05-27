package com.smartlogix.ms_reportes.dto;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ReporteInventarioDTOTest {
    @Test void constructor_y_getters() {
        ReporteInventarioDTO r = new ReporteInventarioDTO(50, 5, new BigDecimal("250000"));
        assertEquals(50, r.getTotalProductos()); assertEquals(5, r.getProductosBajoStock());
        assertEquals(new BigDecimal("250000"), r.getValorTotalInventario());
    }
    @Test void setters() {
        ReporteInventarioDTO r = new ReporteInventarioDTO(0,0,BigDecimal.ZERO);
        r.setTotalProductos(10); r.setProductosBajoStock(2); r.setValorTotalInventario(BigDecimal.TEN);
        assertEquals(10, r.getTotalProductos()); assertEquals(2, r.getProductosBajoStock());
    }
    @Test void equals_mismosDatos() {
        ReporteInventarioDTO r1 = new ReporteInventarioDTO(5,1,BigDecimal.TEN);
        ReporteInventarioDTO r2 = new ReporteInventarioDTO(5,1,BigDecimal.TEN);
        assertEquals(r1, r2); assertEquals(r1.hashCode(), r2.hashCode());
    }
    @Test void equals_distinto() { assertNotEquals(new ReporteInventarioDTO(5,1,null), new ReporteInventarioDTO(6,1,null)); }
    @Test void equals_null_otroTipo_mismaInstancia() {
        ReporteInventarioDTO r = new ReporteInventarioDTO(0,0,null);
        assertNotEquals(r, null); assertEquals(r, r); assertNotEquals(r, "str");
    }
    @Test void toString_noEsNulo() { assertNotNull(new ReporteInventarioDTO(0,0,null).toString()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new ReporteInventarioDTO(0,0,null)::hashCode); }
}
