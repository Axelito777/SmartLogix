package com.smartlogix.ms_pagos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PagoRequest {

    @NotNull(message = "El pedidoId es obligatorio")
    private Long pedidoId;

    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser mayor a 0")
    private Double monto;

    private String metodoPago;
}