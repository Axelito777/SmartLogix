package com.smartlogix.ms_proveedores.service;

import com.smartlogix.ms_proveedores.dto.ProveedorRequest;
import com.smartlogix.ms_proveedores.dto.ProveedorResponse;
import com.smartlogix.ms_proveedores.exception.ProveedorNotFoundException;
import com.smartlogix.ms_proveedores.model.Proveedor;
import com.smartlogix.ms_proveedores.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio de negocio para la gestión de proveedores.
 * <p>
 * Implementa las operaciones CRUD sobre {@link com.smartlogix.ms_proveedores.model.Proveedor}.
 * </p>
 *
 * @author SmartLogix Team
 */
@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    /**
     * Retorna la lista de todos los proveedores registrados.
     *
     * @return lista de {@link ProveedorResponse}; vacía si no hay proveedores
     */
    public List<ProveedorResponse> listar() {
        return proveedorRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un proveedor por su identificador.
     *
     * @param id identificador numérico del proveedor
     * @return {@link ProveedorResponse} con los datos del proveedor
     * @throws com.smartlogix.ms_proveedores.exception.ProveedorNotFoundException si no existe el proveedor
     */
    public ProveedorResponse obtener(Long id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new ProveedorNotFoundException(id));
        return convertirAResponse(proveedor);
    }

    /**
     * Crea y persiste un nuevo proveedor.
     *
     * @param request datos del proveedor a registrar
     * @return {@link ProveedorResponse} del proveedor recién creado
     */
    public ProveedorResponse crear(ProveedorRequest request) {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(request.getNombre());
        proveedor.setEmail(request.getEmail());
        proveedor.setTelefono(request.getTelefono());
        proveedor.setDireccion(request.getDireccion());
        proveedorRepository.save(proveedor);
        return convertirAResponse(proveedor);
    }

    /**
     * Actualiza los datos de un proveedor existente.
     *
     * @param id      identificador numérico del proveedor
     * @param request nuevos datos del proveedor
     * @return {@link ProveedorResponse} con los datos actualizados
     * @throws com.smartlogix.ms_proveedores.exception.ProveedorNotFoundException si no existe el proveedor
     */
    public ProveedorResponse actualizar(Long id, ProveedorRequest request) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new ProveedorNotFoundException(id));
        proveedor.setNombre(request.getNombre());
        proveedor.setEmail(request.getEmail());
        proveedor.setTelefono(request.getTelefono());
        proveedor.setDireccion(request.getDireccion());
        proveedorRepository.save(proveedor);
        return convertirAResponse(proveedor);
    }

    /**
     * Elimina un proveedor del sistema.
     *
     * @param id identificador numérico del proveedor a eliminar
     * @throws com.smartlogix.ms_proveedores.exception.ProveedorNotFoundException si no existe el proveedor
     */
    public void eliminar(Long id) {
        proveedorRepository.findById(id)
                .orElseThrow(() -> new ProveedorNotFoundException(id));
        proveedorRepository.deleteById(id);
    }

    private ProveedorResponse convertirAResponse(Proveedor p) {
        return new ProveedorResponse(
                p.getId(),
                p.getNombre(),
                p.getEmail(),
                p.getTelefono(),
                p.getDireccion(),
                p.getCreatedAt()
        );
    }
}