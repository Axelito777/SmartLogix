package com.smartlogix.ms_pagos.dto;

import lombok.Data;
import lombok.AllArgsConstructor;

/**
 * DTO de salida con los datos públicos de un pago.
 *
 * @author SmartLogix Team
 */
@Data
@AllArgsConstructor
public class PagoResponse {
    private Long id;
    private Long pedidoId;
    private Double monto;
    private String estado;
    private String metodoPago;
}
