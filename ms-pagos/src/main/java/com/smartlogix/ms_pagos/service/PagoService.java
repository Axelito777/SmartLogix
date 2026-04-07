package com.smartlogix.ms_pagos.service;

import com.smartlogix.ms_pagos.model.Pago;
import com.smartlogix.ms_pagos.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class PagoService {

    @Autowired
    private PagoRepository repository;

    public Pago procesarPago(Pago pago) {
        pago.setFechaPago(LocalDateTime.now());
        pago.setTransaccionId("TXN-" + UUID.randomUUID().toString().substring(0, 10).toUpperCase());
        
        // Simulamos que el 90% de los pagos se aprueban para el MVP
        if (pago.getMonto() != null && pago.getMonto() > 0) {
            pago.setEstado("APROBADO");
        } else {
            pago.setEstado("RECHAZADO");
        }
        
        return repository.save(pago);
    }

    public Optional<Pago> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Pago> obtenerPorPedidoId(Long pedidoId) {
        return repository.findByPedidoId(pedidoId);
    }
}