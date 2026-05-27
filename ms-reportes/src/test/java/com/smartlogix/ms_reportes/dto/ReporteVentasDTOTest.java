package com.smartlogix.ms_reportes.dto;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ReporteVentasDTOTest {
    @Test void constructor_y_getters() {
        ReporteVentasDTO r = new ReporteVentasDTO(10, 7, 3, new BigDecimal("100000"), new BigDecimal("14285.71"));
        assertEquals(10, r.getTotalPedidos()); assertEquals(7, r.getPedidosCompletados()); assertEquals(3, r.getPedidosPendientes());
        assertEquals(new BigDecimal("100000"), r.getTotalRecaudado());
    }
    @Test void setters() {
        ReporteVentasDTO r = new ReporteVentasDTO(0,0,0,BigDecimal.ZERO,BigDecimal.ZERO);
        r.setTotalPedidos(5); r.setPedidosCompletados(3); r.setPedidosPendientes(2);
        r.setTotalRecaudado(BigDecimal.TEN); r.setTicketPromedio(BigDecimal.ONE);
        assertEquals(5, r.getTotalPedidos()); assertEquals(3, r.getPedidosCompletados());
    }
    @Test void equals_mismosDatos() {
        ReporteVentasDTO r1 = new ReporteVentasDTO(1,1,0,BigDecimal.ONE,BigDecimal.ONE);
        ReporteVentasDTO r2 = new ReporteVentasDTO(1,1,0,BigDecimal.ONE,BigDecimal.ONE);
        assertEquals(r1, r2); assertEquals(r1.hashCode(), r2.hashCode());
    }
    @Test void equals_distinto() { assertNotEquals(new ReporteVentasDTO(1,0,1,null,null), new ReporteVentasDTO(2,0,2,null,null)); }
    @Test void equals_null_otroTipo_mismaInstancia() {
        ReporteVentasDTO r = new ReporteVentasDTO(0,0,0,null,null);
        assertNotEquals(r, null); assertEquals(r, r); assertNotEquals(r, "str");
    }
    @Test void toString_noEsNulo() { assertNotNull(new ReporteVentasDTO(0,0,0,null,null).toString()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new ReporteVentasDTO(0,0,0,null,null)::hashCode); }
}
