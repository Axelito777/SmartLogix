package ms_proveedores.repository; // <-- Verifica tu paquete

import org.springframework.data.jpa.repository.JpaRepository; // <-- Que importe bien tu clase Proveedor
import org.springframework.stereotype.Repository;

import ms_proveedores.entity.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}