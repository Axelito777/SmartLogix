package com.smartlogix.ms_pagos.service;

import com.smartlogix.ms_pagos.dto.PagoRequest;
import com.smartlogix.ms_pagos.dto.PagoResponse;
import com.smartlogix.ms_pagos.exception.PagoNotFoundException;
import com.smartlogix.ms_pagos.model.Pago;
import com.smartlogix.ms_pagos.repository.PagoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PagoServiceTest {

    @Mock private PagoRepository pagoRepository;
    @InjectMocks private PagoService pagoService;

    private Pago pago;
    private PagoRequest request;

    @BeforeEach
    void setUp() {
        pago = new Pago();
        pago.setId(1L);
        pago.setPedidoId(100L);
        pago.setMonto(50000.0);
        pago.setEstado("PROCESADO");
        pago.setMetodoPago("TARJETA");

        request = new PagoRequest();
        request.setPedidoId(100L);
        request.setMonto(50000.0);
        request.setMetodoPago("TARJETA");
    }

    @Test
    void procesar_exitoso_retornaResponse() {
        when(pagoRepository.save(any())).thenReturn(pago);

        PagoResponse response = pagoService.procesar(request);

        assertNotNull(response);
        assertEquals(100L, response.getPedidoId());
        assertEquals("PROCESADO", response.getEstado());
        assertEquals(50000.0, response.getMonto());
        verify(pagoRepository).save(any());
    }

    @Test
    void obtener_existente_retornaResponse() {
        when(pagoRepository.findById(1L)).thenReturn(Optional.of(pago));

        PagoResponse response = pagoService.obtener(1L);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals(50000.0, response.getMonto());
    }

    @Test
    void obtener_noExiste_lanzaExcepcion() {
        when(pagoRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(PagoNotFoundException.class, () -> pagoService.obtener(99L));
    }

    @Test
    void obtenerPorPedido_retornaLista() {
        when(pagoRepository.findByPedidoId(100L)).thenReturn(List.of(pago));

        List<PagoResponse> lista = pagoService.obtenerPorPedido(100L);

        assertEquals(1, lista.size());
        assertEquals(100L, lista.get(0).getPedidoId());
    }

    @Test
    void obtenerPorPedido_sinPagos_retornaVacio() {
        when(pagoRepository.findByPedidoId(999L)).thenReturn(Collections.emptyList());

        assertTrue(pagoService.obtenerPorPedido(999L).isEmpty());
    }

    @Test
    void listar_retornaLista() {
        when(pagoRepository.findAll()).thenReturn(List.of(pago));

        List<PagoResponse> lista = pagoService.listar();

        assertEquals(1, lista.size());
    }

    @Test
    void listar_vacio_retornaListaVacia() {
        when(pagoRepository.findAll()).thenReturn(Collections.emptyList());

        assertTrue(pagoService.listar().isEmpty());
    }
}
