package ms_proveedores.service;

import ms_proveedores.entity.Proveedor;
import ms_proveedores.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Crear proveedor
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    // Listar proveedores
    public List<Proveedor> obtenerTodos() {
        return proveedorRepository.findAll();
    }
}