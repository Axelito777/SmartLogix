package com.smartlogix.ms_pagos.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class PagoResponse {
    private Long id;
    private Long pedidoId;
    private Double monto;
    private String estado;
    private String metodoPago;
}
