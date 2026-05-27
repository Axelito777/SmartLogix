package com.smartlogix.ms_proveedores.repository;

import com.smartlogix.ms_proveedores.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad {@link com.smartlogix.ms_proveedores.model.Proveedor}.
 * <p>
 * Hereda las operaciones CRUD estándar de {@link JpaRepository}.
 * </p>
 *
 * @author SmartLogix Team
 */
@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}