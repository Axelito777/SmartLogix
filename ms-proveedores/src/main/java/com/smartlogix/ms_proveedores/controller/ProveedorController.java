package com.smartlogix.ms_proveedores.controller;

import com.smartlogix.ms_proveedores.dto.ProveedorRequest;
import com.smartlogix.ms_proveedores.dto.ProveedorResponse;
import com.smartlogix.ms_proveedores.service.ProveedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador REST para la gestión de proveedores.
 * <p>
 * Expone operaciones CRUD sobre proveedores bajo la ruta base {@code /api/proveedores}.
 * </p>
 *
 * @author SmartLogix Team
 */
@RestController
@RequestMapping("/api/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;

    /**
     * Retorna la lista completa de proveedores registrados.
     *
     * @return {@code 200 OK} con la lista de {@link ProveedorResponse}
     */
    @GetMapping
    public ResponseEntity<List<ProveedorResponse>> listar() {
        return ResponseEntity.ok(proveedorService.listar());
    }

    /**
     * Obtiene un proveedor por su identificador.
     *
     * @param id identificador numérico del proveedor
     * @return {@code 200 OK} con el {@link ProveedorResponse} encontrado
     * @throws com.smartlogix.ms_proveedores.exception.ProveedorNotFoundException si no existe el proveedor
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(proveedorService.obtener(id));
    }

    /**
     * Registra un nuevo proveedor en el sistema.
     *
     * @param request datos del proveedor a crear
     * @return {@code 200 OK} con el {@link ProveedorResponse} del proveedor creado
     */
    @PostMapping
    public ResponseEntity<ProveedorResponse> crear(@Valid @RequestBody ProveedorRequest request) {
        return ResponseEntity.ok(proveedorService.crear(request));
    }

    /**
     * Actualiza los datos de contacto de un proveedor existente.
     *
     * @param id      identificador numérico del proveedor
     * @param request nuevos datos del proveedor
     * @return {@code 200 OK} con el {@link ProveedorResponse} actualizado
     * @throws com.smartlogix.ms_proveedores.exception.ProveedorNotFoundException si no existe el proveedor
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProveedorResponse> actualizar(@PathVariable Long id, @Valid @RequestBody ProveedorRequest request) {
        return ResponseEntity.ok(proveedorService.actualizar(id, request));
    }

    /**
     * Elimina un proveedor del sistema.
     *
     * @param id identificador numérico del proveedor a eliminar
     * @return {@code 204 No Content} si la eliminación fue exitosa
     * @throws com.smartlogix.ms_proveedores.exception.ProveedorNotFoundException si no existe el proveedor
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        proveedorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
