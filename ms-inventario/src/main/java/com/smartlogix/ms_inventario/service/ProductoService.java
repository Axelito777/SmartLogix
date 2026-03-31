package com.smartlogix.ms_inventario.service;

import com.smartlogix.ms_inventario.dto.ProductoRequest;
import com.smartlogix.ms_inventario.dto.ProductoResponse;
import com.smartlogix.ms_inventario.model.Producto;
import com.smartlogix.ms_inventario.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    // Listar todos los productos
    public List<ProductoResponse> listar() {
        return productoRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    // Obtener un producto por id
    public ProductoResponse obtener(String id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Producto no encontrado"));
        return convertirAResponse(producto);
    }

    // Crear un producto nuevo
    public ProductoResponse crear(ProductoRequest request) {
        Producto producto = new Producto();
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());
        producto.setStockMinimo(request.getStockMinimo());
        producto.setBodegaId(request.getBodegaId());
        producto.setProveedorId(request.getProveedorId());

        productoRepository.save(producto);
        return convertirAResponse(producto);
    }

    // Actualizar stock
    public ProductoResponse actualizarStock(
            String id, Integer cantidad) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Producto no encontrado"));

        int stockNuevo = producto.getStock() + cantidad;

        if (stockNuevo < 0) {
            throw new RuntimeException("Stock insuficiente");
        }

        producto.setStock(stockNuevo);
        productoRepository.save(producto);
        return convertirAResponse(producto);
    }

    // Productos con bajo stock
    public List<ProductoResponse> bajoStock() {
        return productoRepository
                .findByStockLessThanEqual(10)
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    // Convierte Producto a ProductoResponse
    private ProductoResponse convertirAResponse(Producto producto) {
        return new ProductoResponse(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getStockMinimo(),
                producto.getBodegaId(),
                producto.getProveedorId(),
                producto.getCreatedAt()
        );
    }
}