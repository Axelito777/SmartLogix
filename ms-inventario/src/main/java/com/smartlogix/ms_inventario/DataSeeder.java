package com.smartlogix.ms_inventario;

import com.smartlogix.ms_inventario.model.Producto;
import com.smartlogix.ms_inventario.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final ProductoRepository productoRepository;

    @Override
    public void run(String... args) {
        if (productoRepository.count() == 0) {
            productoRepository.save(crearProducto("Laptop Dell", "Laptop 15 pulgadas i5", new BigDecimal("599990"), 50, 5));
            productoRepository.save(crearProducto("Mouse Logitech", "Mouse inalámbrico", new BigDecimal("19990"), 100, 10));
            productoRepository.save(crearProducto("Teclado Mecánico", "Teclado RGB", new BigDecimal("49990"), 30, 5));
            productoRepository.save(crearProducto("Monitor 24\"", "Monitor Full HD", new BigDecimal("149990"), 20, 3));
            productoRepository.save(crearProducto("Audífonos Sony", "Audífonos bluetooth", new BigDecimal("89990"), 8, 10));
            System.out.println("✅ Productos de prueba creados");
        }
    }

    private Producto crearProducto(String nombre, String descripcion, BigDecimal precio, int stock, int stockMinimo) {
        Producto p = new Producto();
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setPrecio(precio);
        p.setStock(stock);
        p.setStockMinimo(stockMinimo);
        return p;
    }
}
