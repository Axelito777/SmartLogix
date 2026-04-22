package com.smartlogix.ms_pagos.service;

import com.smartlogix.ms_pagos.dto.PagoRequest;
import com.smartlogix.ms_pagos.dto.PagoResponse;
import com.smartlogix.ms_pagos.exception.PagoNotFoundException;
import com.smartlogix.ms_pagos.model.Pago;
import com.smartlogix.ms_pagos.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoResponse procesar(PagoRequest request) {
        Pago pago = new Pago();
        pago.setPedidoId(request.getPedidoId());
        pago.setMonto(request.getMonto());
        pago.setMetodoPago(request.getMetodoPago());
        pago.setEstado("PROCESADO");
        pagoRepository.save(pago);
        return convertirAResponse(pago);
    }

    public PagoResponse obtener(Long id) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new PagoNotFoundException(id));
        return convertirAResponse(pago);
    }

    public List<PagoResponse> obtenerPorPedido(Long pedidoId) {
        return pagoRepository.findByPedidoId(pedidoId)
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    private PagoResponse convertirAResponse(Pago p) {
        return new PagoResponse(p.getId(), p.getPedidoId(), p.getMonto(), p.getEstado(), p.getMetodoPago());
    }
}