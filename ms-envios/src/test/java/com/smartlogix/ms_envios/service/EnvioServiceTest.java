package com.smartlogix.ms_envios.service;

import com.smartlogix.ms_envios.client.NotificacionesClient;
import com.smartlogix.ms_envios.dto.EnvioRequest;
import com.smartlogix.ms_envios.dto.EnvioResponse;
import com.smartlogix.ms_envios.exception.EnvioNotFoundException;
import com.smartlogix.ms_envios.model.Envio;
import com.smartlogix.ms_envios.repository.EnvioRepository;
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
class EnvioServiceTest {

    @Mock private EnvioRepository envioRepository;
    @Mock private NotificacionesClient notificacionesClient;
    @InjectMocks private EnvioService envioService;

    private Envio envio;

    @BeforeEach
    void setUp() {
        envio = new Envio();
        envio.setId(1L);
        envio.setPedidoId("ped-1");
        envio.setTrackingNumber("ABC12345");
        envio.setEstado("PREPARANDO");
        envio.setTransportista("DHL");
    }

    @Test
    void crear_exitoso_retornaResponse() {
        EnvioRequest request = new EnvioRequest();
        request.setPedidoId("ped-1");
        request.setTransportista("DHL");
        when(envioRepository.save(any())).thenReturn(envio);

        EnvioResponse response = envioService.crear(request);

        assertNotNull(response);
        assertEquals("ped-1", response.getPedidoId());
        assertEquals("PREPARANDO", response.getEstado());
        verify(envioRepository).save(any());
    }

    @Test
    void crear_notificacionFalla_sigueCreando() {
        EnvioRequest request = new EnvioRequest();
        request.setPedidoId("ped-2");
        request.setTransportista("Chilexpress");
        when(envioRepository.save(any())).thenReturn(envio);
        doThrow(new RuntimeException("feign error")).when(notificacionesClient).enviarNotificacion(any());

        EnvioResponse response = envioService.crear(request);

        assertNotNull(response);
    }

    @Test
    void listar_retornaLista() {
        when(envioRepository.findAll()).thenReturn(List.of(envio));

        List<EnvioResponse> lista = envioService.listar();

        assertEquals(1, lista.size());
        assertEquals("DHL", lista.get(0).getTransportista());
    }

    @Test
    void listar_vacio_retornaListaVacia() {
        when(envioRepository.findAll()).thenReturn(Collections.emptyList());

        assertTrue(envioService.listar().isEmpty());
    }

    @Test
    void obtener_existente_retornaResponse() {
        when(envioRepository.findById(1L)).thenReturn(Optional.of(envio));

        EnvioResponse response = envioService.obtener(1L);

        assertNotNull(response);
        assertEquals(1L, response.getId());
    }

    @Test
    void obtener_noExiste_lanzaExcepcion() {
        when(envioRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(EnvioNotFoundException.class, () -> envioService.obtener(99L));
    }
}
