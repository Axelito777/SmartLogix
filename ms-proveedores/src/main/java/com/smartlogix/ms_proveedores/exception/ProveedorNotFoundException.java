package com.smartlogix.ms_proveedores.exception;

public class ProveedorNotFoundException extends RuntimeException {
    public ProveedorNotFoundException(Long id) {
        super("Proveedor no encontrado con id: " + id);
    }
}
