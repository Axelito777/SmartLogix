package com.smartlogix.ms_pagos.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad JPA que representa el pago asociado a un pedido.
 *
 * @author SmartLogix Team
 */
@Data
@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long pedidoId;

    @Column(nullable = false)
    private Double monto;

    private String estado;
    private String metodoPago;
}