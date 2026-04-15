package com.smartlogix.ms_clientes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ClienteRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El RUT es obligatorio")
    // Valida formato 12345678-9 o 12345678-K
    @Pattern(regexp = "^[0-9]{7,8}-[0-9kK]{1}$", message = "Formato de RUT inválido (ej: 12345678-9)")
    private String rut;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ser un correo electrónico válido")
    private String email;

    @NotBlank(message = "El teléfono es obligatorio")
    // Valida formato chileno: +569 seguido de 8 números
    @Pattern(regexp = "^\\+569[0-9]{8}$", message = "El teléfono debe tener formato +569XXXXXXXX")
    private String telefono;

    private String direccion;
}