package com.smartlogix.ms_clientes.service;

import com.smartlogix.ms_clientes.dto.ClienteRequest;
import com.smartlogix.ms_clientes.dto.ClienteResponse;
import com.smartlogix.ms_clientes.model.Cliente;
import com.smartlogix.ms_clientes.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    private ClienteRequest request;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        request = new ClienteRequest();
        request.setNombre("Juan Perez");
        request.setRut("12345678-9");
        request.setEmail("juan@smartlogix.cl");

        cliente = new Cliente();
        cliente.setId("1");
        cliente.setNombre("Juan Perez");
        cliente.setRut("12345678-9");
        cliente.setEmail("juan@smartlogix.cl");
    }

    @Test
    void cuandoCrearClienteNuevo_entoncesRetornaClienteResponse() {
        // Simular que el email y rut NO existen
        when(clienteRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(clienteRepository.findByRut(anyString())).thenReturn(Optional.empty());
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        ClienteResponse response = clienteService.crear(request);

        assertNotNull(response);
        assertEquals("Juan Perez", response.getNombre());
        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }

    @Test
    void cuandoCrearConEmailDuplicado_entoncesLanzaExcepcion() {
        // Simular que el email YA existe
        when(clienteRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(cliente));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            clienteService.crear(request);
        });

        assertEquals("El email ya está registrado", exception.getMessage());
        verify(clienteRepository, never()).save(any(Cliente.class));
    }
}
