package com.smartlogix.ms_reportes.service;

import com.smartlogix.ms_reportes.client.InventarioClient;
import com.smartlogix.ms_reportes.client.PedidosClient;
import com.smartlogix.ms_reportes.dto.PedidoDTO;
import com.smartlogix.ms_reportes.dto.ProductoDTO;
import com.smartlogix.ms_reportes.dto.ReporteInventarioDTO;
import com.smartlogix.ms_reportes.dto.ReporteVentasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Servicio de negocio para la generación de reportes de SmartLogix.
 * <p>
 * Consume datos de {@code ms-pedidos} y {@code ms-inventario} vía Feign
 * para producir reportes agregados de ventas y estado del inventario.
 * </p>
 *
 * @author SmartLogix Team
 */
@Service
@RequiredArgsConstructor
public class ReporteService {

    private final PedidosClient pedidosClient;
    private final InventarioClient inventarioClient;

    /**
     * Genera el reporte de ventas a partir de los pedidos de {@code ms-pedidos}.
     * <p>
     * Calcula totales de pedidos completados ({@code ENTREGADO}) y pendientes,
     * el monto total recaudado y el ticket promedio.
     * </p>
     *
     * @return {@link ReporteVentasDTO} con los indicadores de ventas consolidados
     */
    public ReporteVentasDTO generarReporteVentas() {
        List<PedidoDTO> pedidos = pedidosClient.getPedidos();

        int total = pedidos.size();
        List<PedidoDTO> completados = pedidos.stream()
                .filter(p -> "ENTREGADO".equals(p.getEstado()))
                .toList();
        List<PedidoDTO> pendientes = pedidos.stream()
                .filter(p -> "PENDIENTE".equals(p.getEstado()))
                .toList();

        BigDecimal totalRecaudado = completados.stream()
                .map(p -> p.getTotal() != null ? p.getTotal() : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal ticketPromedio = completados.isEmpty() ? BigDecimal.ZERO :
                totalRecaudado.divide(BigDecimal.valueOf(completados.size()), 2, RoundingMode.HALF_UP);

        return new ReporteVentasDTO(total, completados.size(), pendientes.size(), totalRecaudado, ticketPromedio);
    }

    /**
     * Genera el reporte de inventario a partir de los productos de {@code ms-inventario}.
     * <p>
     * Calcula el total de productos, la cantidad con bajo stock (stock ≤ stockMínimo)
     * y el valor total del inventario (precio × stock).
     * </p>
     *
     * @return {@link ReporteInventarioDTO} con los indicadores del inventario
     */
    public ReporteInventarioDTO generarReporteInventario() {
        List<ProductoDTO> productos = inventarioClient.getProductos();

        int total = productos.size();
        long bajoStock = productos.stream()
                .filter(p -> p.getStock() != null && p.getStockMinimo() != null && p.getStock() <= p.getStockMinimo())
                .count();

        BigDecimal valorTotal = productos.stream()
                .map(p -> {
                    if (p.getPrecio() == null || p.getStock() == null) return BigDecimal.ZERO;
                    return p.getPrecio().multiply(BigDecimal.valueOf(p.getStock()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new ReporteInventarioDTO(total, (int) bajoStock, valorTotal);
    }
}
