package com.smartlogix.ms_notificaciones.service;

import com.smartlogix.ms_notificaciones.dto.NotificacionRequest;
import com.smartlogix.ms_notificaciones.dto.NotificacionResponse;
import com.smartlogix.ms_notificaciones.model.Notificacion;
import com.smartlogix.ms_notificaciones.repository.NotificacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NotificacionServiceTest {

    @Mock private NotificacionRepository notificacionRepository;
    @InjectMocks private NotificacionService notificacionService;

    private Notificacion notificacion;

    @BeforeEach
    void setUp() {
        notificacion = new Notificacion();
        notificacion.setId(1L);
        notificacion.setUsuarioId(10L);
        notificacion.setMensaje("Pedido creado exitosamente");
        notificacion.setFechaEnvio(LocalDateTime.now());
    }

    @Test
    void enviar_exitoso_retornaResponse() {
        NotificacionRequest request = new NotificacionRequest();
        request.setUsuarioId(10L);
        request.setMensaje("Pedido creado");
        when(notificacionRepository.save(any())).thenReturn(notificacion);

        NotificacionResponse response = notificacionService.enviar(request);

        assertNotNull(response);
        assertEquals(10L, response.getUsuarioId());
        assertEquals("Pedido creado", response.getMensaje());
        verify(notificacionRepository).save(any());
    }

    @Test
    void obtenerPorUsuario_retornaLista() {
        when(notificacionRepository.findByUsuarioId(10L)).thenReturn(List.of(notificacion));

        List<NotificacionResponse> lista = notificacionService.obtenerPorUsuario(10L);

        assertEquals(1, lista.size());
        assertEquals(10L, lista.get(0).getUsuarioId());
    }

    @Test
    void obtenerPorUsuario_sinNotificaciones_retornaVacio() {
        when(notificacionRepository.findByUsuarioId(99L)).thenReturn(Collections.emptyList());

        assertTrue(notificacionService.obtenerPorUsuario(99L).isEmpty());
    }

    @Test
    void listar_retornaTodasLasNotificaciones() {
        when(notificacionRepository.findAll()).thenReturn(List.of(notificacion, notificacion));

        List<NotificacionResponse> lista = notificacionService.listar();

        assertEquals(2, lista.size());
    }

    @Test
    void listar_vacio_retornaListaVacia() {
        when(notificacionRepository.findAll()).thenReturn(Collections.emptyList());

        assertTrue(notificacionService.listar().isEmpty());
    }
}
