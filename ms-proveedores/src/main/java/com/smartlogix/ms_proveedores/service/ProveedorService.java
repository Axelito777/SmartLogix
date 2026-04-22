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

@Service
@RequiredArgsConstructor
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public List<ProveedorResponse> listar() {
        return proveedorRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public ProveedorResponse obtener(Long id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new ProveedorNotFoundException(id));
        return convertirAResponse(proveedor);
    }

    public ProveedorResponse crear(ProveedorRequest request) {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(request.getNombre());
        proveedor.setEmail(request.getEmail());
        proveedor.setTelefono(request.getTelefono());
        proveedor.setDireccion(request.getDireccion());
        proveedorRepository.save(proveedor);
        return convertirAResponse(proveedor);
    }

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