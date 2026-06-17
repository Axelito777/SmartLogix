package com.smartlogix.ms_reportes.service;

import com.smartlogix.ms_reportes.client.InventarioClient;
import com.smartlogix.ms_reportes.client.PedidosClient;
import com.smartlogix.ms_reportes.dto.PedidoDTO;
import com.smartlogix.ms_reportes.dto.ProductoDTO;
import com.smartlogix.ms_reportes.dto.ReporteInventarioDTO;
import com.smartlogix.ms_reportes.dto.ReporteVentasDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Pruebas unitarias de {@code ReporteService} usando mocks de
 * {@link PedidosClient} e {@link InventarioClient}.
 *
 * @author SmartLogix Team
 */
@ExtendWith(MockitoExtension.class)
class ReporteServiceTest {

    @Mock private PedidosClient pedidosClient;
    @Mock private InventarioClient inventarioClient;
    @InjectMocks private ReporteService reporteService;

    @Test
    void generarReporteVentas_conPedidos_retornaReporte() {
        PedidoDTO entregado = new PedidoDTO();
        entregado.setId("p1"); entregado.setEstado("ENTREGADO"); entregado.setTotal(new BigDecimal("10000"));
        PedidoDTO pendiente = new PedidoDTO();
        pendiente.setId("p2"); pendiente.setEstado("PENDIENTE"); pendiente.setTotal(new BigDecimal("5000"));

        when(pedidosClient.getPedidos()).thenReturn(List.of(entregado, pendiente));

        ReporteVentasDTO reporte = reporteService.generarReporteVentas();

        assertNotNull(reporte);
        assertEquals(2, reporte.getTotalPedidos());
        assertEquals(1, reporte.getPedidosCompletados());
        assertEquals(1, reporte.getPedidosPendientes());
        assertEquals(new BigDecimal("10000"), reporte.getTotalRecaudado());
    }

    @Test
    void generarReporteVentas_sinPedidos_retornaReporteVacio() {
        when(pedidosClient.getPedidos()).thenReturn(Collections.emptyList());

        ReporteVentasDTO reporte = reporteService.generarReporteVentas();

        assertNotNull(reporte);
        assertEquals(0, reporte.getTotalPedidos());
        assertEquals(BigDecimal.ZERO, reporte.getTotalRecaudado());
        assertEquals(BigDecimal.ZERO, reporte.getTicketPromedio());
    }

    @Test
    void generarReporteVentas_pedidoSinTotal_usaCero() {
        PedidoDTO entregado = new PedidoDTO();
        entregado.setEstado("ENTREGADO");
        entregado.setTotal(null);
        when(pedidosClient.getPedidos()).thenReturn(List.of(entregado));

        ReporteVentasDTO reporte = reporteService.generarReporteVentas();

        assertEquals(BigDecimal.ZERO, reporte.getTotalRecaudado());
    }

    @Test
    void generarReporteInventario_conProductos_retornaReporte() {
        ProductoDTO normal = new ProductoDTO();
        normal.setId("pr1"); normal.setPrecio(new BigDecimal("100")); normal.setStock(50); normal.setStockMinimo(10);
        ProductoDTO bajoStock = new ProductoDTO();
        bajoStock.setId("pr2"); bajoStock.setPrecio(new BigDecimal("200")); bajoStock.setStock(5); bajoStock.setStockMinimo(10);

        when(inventarioClient.getProductos()).thenReturn(List.of(normal, bajoStock));

        ReporteInventarioDTO reporte = reporteService.generarReporteInventario();

        assertNotNull(reporte);
        assertEquals(2, reporte.getTotalProductos());
        assertEquals(1, reporte.getProductosBajoStock());
        assertTrue(reporte.getValorTotalInventario().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void generarReporteInventario_sinProductos_retornaReporteVacio() {
        when(inventarioClient.getProductos()).thenReturn(Collections.emptyList());

        ReporteInventarioDTO reporte = reporteService.generarReporteInventario();

        assertNotNull(reporte);
        assertEquals(0, reporte.getTotalProductos());
        assertEquals(0, reporte.getProductosBajoStock());
        assertEquals(BigDecimal.ZERO, reporte.getValorTotalInventario());
    }

    @Test
    void generarReporteInventario_productoConCamposNulos_usaCero() {
        ProductoDTO p = new ProductoDTO();
        p.setId("pr1"); p.setPrecio(null); p.setStock(null); p.setStockMinimo(null);
        when(inventarioClient.getProductos()).thenReturn(List.of(p));

        ReporteInventarioDTO reporte = reporteService.generarReporteInventario();

        assertEquals(BigDecimal.ZERO, reporte.getValorTotalInventario());
        assertEquals(0, reporte.getProductosBajoStock());
    }
}
