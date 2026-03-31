package com.smartlogix.ms_clientes.dto;

import lombok.Data;

@Data
public class ClienteRequest {
    private String nombre;
    private String rut;
    private String email;
    private String telefono;
    private String direccion;
}