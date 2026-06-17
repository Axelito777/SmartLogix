package com.smartlogix.ms_proveedores.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * DTO de entrada con los datos requeridos para crear o actualizar un proveedor.
 *
 * @author SmartLogix Team
 */
@Data
public class ProveedorRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "El email no es válido")
    private String email;

    private String telefono;
    private String direccion;
}
