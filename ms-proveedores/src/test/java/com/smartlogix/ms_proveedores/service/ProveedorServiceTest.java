package com.smartlogix.ms_proveedores.service;

import com.smartlogix.ms_proveedores.dto.ProveedorRequest;
import com.smartlogix.ms_proveedores.dto.ProveedorResponse;
import com.smartlogix.ms_proveedores.exception.ProveedorNotFoundException;
import com.smartlogix.ms_proveedores.model.Proveedor;
import com.smartlogix.ms_proveedores.repository.ProveedorRepository;
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

/**
 * Pruebas unitarias de {@code ProveedorService} usando un mock de
 * {@link ProveedorRepository}.
 *
 * @author SmartLogix Team
 */
@ExtendWith(MockitoExtension.class)
class ProveedorServiceTest {

    @Mock private ProveedorRepository proveedorRepository;
    @InjectMocks private ProveedorService proveedorService;

    private Proveedor proveedor;
    private ProveedorRequest request;

    @BeforeEach
    void setUp() {
        proveedor = new Proveedor();
        proveedor.setId(1L);
        proveedor.setNombre("Proveedor S.A.");
        proveedor.setEmail("proveedor@test.cl");
        proveedor.setTelefono("+56912345678");
        proveedor.setDireccion("Av. Siempre Viva 742");

        request = new ProveedorRequest();
        request.setNombre("Proveedor S.A.");
        request.setEmail("proveedor@test.cl");
        request.setTelefono("+56912345678");
        request.setDireccion("Av. Siempre Viva 742");
    }

    @Test
    void listar_retornaLista() {
        when(proveedorRepository.findAll()).thenReturn(List.of(proveedor));

        List<ProveedorResponse> lista = proveedorService.listar();

        assertEquals(1, lista.size());
        assertEquals("Proveedor S.A.", lista.get(0).getNombre());
    }

    @Test
    void listar_vacio_retornaListaVacia() {
        when(proveedorRepository.findAll()).thenReturn(Collections.emptyList());

        assertTrue(proveedorService.listar().isEmpty());
    }

    @Test
    void obtener_existente_retornaResponse() {
        when(proveedorRepository.findById(1L)).thenReturn(Optional.of(proveedor));

        ProveedorResponse response = proveedorService.obtener(1L);

        assertNotNull(response);
        assertEquals(1L, response.getId());
    }

    @Test
    void obtener_noExiste_lanzaExcepcion() {
        when(proveedorRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ProveedorNotFoundException.class, () -> proveedorService.obtener(99L));
    }

    @Test
    void crear_exitoso_retornaResponse() {
        when(proveedorRepository.save(any())).thenReturn(proveedor);

        ProveedorResponse response = proveedorService.crear(request);

        assertNotNull(response);
        assertEquals("Proveedor S.A.", response.getNombre());
        verify(proveedorRepository).save(any());
    }

    @Test
    void actualizar_existente_retornaResponseActualizado() {
        when(proveedorRepository.findById(1L)).thenReturn(Optional.of(proveedor));
        when(proveedorRepository.save(any())).thenReturn(proveedor);

        ProveedorResponse response = proveedorService.actualizar(1L, request);

        assertNotNull(response);
        verify(proveedorRepository).save(any());
    }

    @Test
    void actualizar_noExiste_lanzaExcepcion() {
        when(proveedorRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ProveedorNotFoundException.class, () -> proveedorService.actualizar(99L, request));
    }

    @Test
    void eliminar_existente_llamaDelete() {
        when(proveedorRepository.findById(1L)).thenReturn(Optional.of(proveedor));

        proveedorService.eliminar(1L);

        verify(proveedorRepository).deleteById(1L);
    }

    @Test
    void eliminar_noExiste_lanzaExcepcion() {
        when(proveedorRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ProveedorNotFoundException.class, () -> proveedorService.eliminar(99L));
    }
}
