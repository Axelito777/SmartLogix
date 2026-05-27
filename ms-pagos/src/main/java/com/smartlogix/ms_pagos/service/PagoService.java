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

/**
 * Servicio de negocio para el procesamiento y consulta de pagos.
 * <p>
 * Registra pagos en estado {@code PROCESADO} y los expone para consulta
 * individual, por pedido o listado completo.
 * </p>
 *
 * @author SmartLogix Team
 */
@Service
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;

    /**
     * Crea y persiste un pago en estado {@code PROCESADO}.
     *
     * @param request datos del pago con {@code pedidoId}, {@code monto} y {@code metodoPago}
     * @return {@link PagoResponse} del pago registrado
     */
    public PagoResponse procesar(PagoRequest request) {
        Pago pago = new Pago();
        pago.setPedidoId(request.getPedidoId());
        pago.setMonto(request.getMonto());
        pago.setMetodoPago(request.getMetodoPago());
        pago.setEstado("PROCESADO");
        pagoRepository.save(pago);
        return convertirAResponse(pago);
    }

    /**
     * Obtiene un pago por su identificador.
     *
     * @param id identificador numérico del pago
     * @return {@link PagoResponse} con los datos del pago
     * @throws com.smartlogix.ms_pagos.exception.PagoNotFoundException si no existe el pago
     */
    public PagoResponse obtener(Long id) {
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new PagoNotFoundException(id));
        return convertirAResponse(pago);
    }

    /**
     * Retorna todos los pagos asociados a un pedido.
     *
     * @param pedidoId identificador numérico del pedido
     * @return lista de {@link PagoResponse}; vacía si el pedido no tiene pagos registrados
     */
    public List<PagoResponse> obtenerPorPedido(Long pedidoId) {
        return pagoRepository.findByPedidoId(pedidoId)
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    private PagoResponse convertirAResponse(Pago p) {
        return new PagoResponse(p.getId(), p.getPedidoId(), p.getMonto(), p.getEstado(), p.getMetodoPago());
    }

    /**
     * Retorna la lista de todos los pagos registrados.
     *
     * @return lista de {@link PagoResponse}; vacía si no hay pagos
     */
    public List<PagoResponse> listar() {
        return pagoRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }
}