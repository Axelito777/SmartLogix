package com.smartlogix.ms_proveedores.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

/**
 * DTO de salida con los datos públicos de un proveedor.
 *
 * @author SmartLogix Team
 */
@Data
@AllArgsConstructor
public class ProveedorResponse {
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private LocalDateTime createdAt;
}
