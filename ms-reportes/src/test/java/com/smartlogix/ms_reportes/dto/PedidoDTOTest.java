package com.smartlogix.ms_reportes.dto;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias del DTO {@link PedidoDTO}.
 *
 * @author SmartLogix Team
 */
class PedidoDTOTest {
    @Test void gettersSetters() {
        PedidoDTO d = new PedidoDTO();
        d.setId("1"); d.setClienteId("c1"); d.setEstado("ENTREGADO"); d.setTipo("NORMAL"); d.setTotal(BigDecimal.TEN);
        assertEquals("1", d.getId()); assertEquals("c1", d.getClienteId()); assertEquals("ENTREGADO", d.getEstado());
        assertEquals("NORMAL", d.getTipo()); assertEquals(BigDecimal.TEN, d.getTotal());
    }
    @Test void equals_mismosDatos() {
        PedidoDTO d1 = new PedidoDTO(); d1.setId("1"); d1.setEstado("A");
        PedidoDTO d2 = new PedidoDTO(); d2.setId("1"); d2.setEstado("A");
        assertEquals(d1, d2); assertEquals(d1.hashCode(), d2.hashCode());
    }
    @Test void equals_distinto() {
        PedidoDTO d1 = new PedidoDTO(); d1.setId("1");
        PedidoDTO d2 = new PedidoDTO(); d2.setId("2");
        assertNotEquals(d1, d2);
    }
    @Test void equals_null_otroTipo_mismaInstancia() {
        PedidoDTO d = new PedidoDTO();
        assertNotEquals(d, null); assertEquals(d, d); assertNotEquals(d, "str");
    }
    @Test void toString_noEsNulo() { assertNotNull(new PedidoDTO().toString()); }
    @Test void hashCode_nulos() { assertDoesNotThrow(new PedidoDTO()::hashCode); }
}
