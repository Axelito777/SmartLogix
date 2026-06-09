package com.smartlogix.ms_clientes.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {
    private String id;
    private String nombre;
    private String rut;
    private String email;
    private String telefono;
    private String direccion;
    private LocalDateTime createdAt;
}