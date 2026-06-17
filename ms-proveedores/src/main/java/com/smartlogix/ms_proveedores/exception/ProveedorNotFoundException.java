package com.smartlogix.ms_proveedores.exception;

/**
 * Excepción lanzada cuando no se encuentra un proveedor con el id solicitado.
 *
 * @author SmartLogix Team
 */
public class ProveedorNotFoundException extends RuntimeException {
    /**
     * Crea la excepción con un mensaje que incluye el id del proveedor buscado.
     *
     * @param id identificador del proveedor que no fue encontrado
     */
    public ProveedorNotFoundException(Long id) {
        super("Proveedor no encontrado con id: " + id);
    }
}
