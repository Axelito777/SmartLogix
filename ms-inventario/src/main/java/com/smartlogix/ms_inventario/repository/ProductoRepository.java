package com.smartlogix.ms_inventario.repository;

import com.smartlogix.ms_inventario.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository
    extends JpaRepository<Producto, String> {

    // Busca productos con stock menor o igual al minimo
    List<Producto> findByStockLessThanEqual(Integer stockMinimo);

    // Busca productos por bodega
    List<Producto> findByBodegaId(String bodegaId);
}