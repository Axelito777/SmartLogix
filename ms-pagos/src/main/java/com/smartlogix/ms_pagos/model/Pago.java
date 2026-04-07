package com.smartlogix.ms_pagos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Data
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedidoId;
    private Double monto;
    private String metodoPago; // Ej: TARJETA, TRANSFERENCIA, PAYPAL
    private String estado;     // Ej: PROCESANDO, APROBADO, RECHAZADO
    private String transaccionId;
    private LocalDateTime fechaPago;
}