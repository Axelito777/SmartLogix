package com.smartlogix.ms_pagos.service;

import com.smartlogix.ms_pagos.entity.Pago;
import com.smartlogix.ms_pagos.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public Pago procesarPago(Pago pago) {
        if (pago.getEstado() == null) {
            pago.setEstado("PROCESADO");
        }
        return pagoRepository.save(pago);
    }

    public Optional<Pago> obtenerPorId(Long id) {
        return pagoRepository.findById(id);
    }

    public List<Pago> obtenerPorPedido(Long pedidoId) {
        return pagoRepository.findByPedidoId(pedidoId);
    }
}