package com.smartlogix.ms_proveedores.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

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
