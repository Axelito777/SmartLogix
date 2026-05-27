package ${package}.service;

import ${package}.dto.${className}Request;
import ${package}.dto.${className}Response;
import ${package}.exception.ResourceNotFoundException;
import ${package}.model.${className};
import ${package}.repository.${className}Repository;
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
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ${className}ServiceTest {

    @Mock
    private ${className}Repository ${className.toLowerCase()}Repository;

    @InjectMocks
    private ${className}Service ${className.toLowerCase()}Service;

    private ${className}Request request;
    private ${className} entidad;

    @BeforeEach
    void setUp() {
        request = new ${className}Request();
        request.setNombre("Nombre de prueba");
        request.setDescripcion("Descripción de prueba");

        entidad = new ${className}();
        entidad.setId("test-uuid-1");
        entidad.setNombre("Nombre de prueba");
        entidad.setDescripcion("Descripción de prueba");
    }

    @Test
    void crear_exitoso_retornaResponse() {
        when(${className.toLowerCase()}Repository.save(any(${className}.class))).thenReturn(entidad);

        ${className}Response response = ${className.toLowerCase()}Service.crear(request);

        assertNotNull(response);
        assertEquals("Nombre de prueba", response.getNombre());
        verify(${className.toLowerCase()}Repository, times(1)).save(any(${className}.class));
    }

    @Test
    void obtener_existente_retornaResponse() {
        when(${className.toLowerCase()}Repository.findById("test-uuid-1")).thenReturn(Optional.of(entidad));

        ${className}Response response = ${className.toLowerCase()}Service.obtener("test-uuid-1");

        assertNotNull(response);
        assertEquals("test-uuid-1", response.getId());
    }

    @Test
    void obtener_noExiste_lanzaExcepcion() {
        when(${className.toLowerCase()}Repository.findById(anyString())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
            () -> ${className.toLowerCase()}Service.obtener("id-inexistente"));
    }

    @Test
    void listar_retornaLista() {
        when(${className.toLowerCase()}Repository.findAll()).thenReturn(List.of(entidad));

        List<${className}Response> lista = ${className.toLowerCase()}Service.listar();

        assertEquals(1, lista.size());
    }

    @Test
    void listar_vacio_retornaListaVacia() {
        when(${className.toLowerCase()}Repository.findAll()).thenReturn(Collections.emptyList());

        assertTrue(${className.toLowerCase()}Service.listar().isEmpty());
    }

    @Test
    void actualizar_existente_retornaResponseActualizado() {
        when(${className.toLowerCase()}Repository.findById("test-uuid-1")).thenReturn(Optional.of(entidad));
        when(${className.toLowerCase()}Repository.save(any(${className}.class))).thenReturn(entidad);

        ${className}Response response = ${className.toLowerCase()}Service.actualizar("test-uuid-1", request);

        assertNotNull(response);
        verify(${className.toLowerCase()}Repository).save(any(${className}.class));
    }

    @Test
    void actualizar_noExiste_lanzaExcepcion() {
        when(${className.toLowerCase()}Repository.findById(anyString())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
            () -> ${className.toLowerCase()}Service.actualizar("id-inexistente", request));
    }

    @Test
    void eliminar_existente_ejecutaDelete() {
        when(${className.toLowerCase()}Repository.existsById("test-uuid-1")).thenReturn(true);

        assertDoesNotThrow(() -> ${className.toLowerCase()}Service.eliminar("test-uuid-1"));
        verify(${className.toLowerCase()}Repository, times(1)).deleteById("test-uuid-1");
    }

    @Test
    void eliminar_noExiste_lanzaExcepcion() {
        when(${className.toLowerCase()}Repository.existsById(anyString())).thenReturn(false);

        assertThrows(ResourceNotFoundException.class,
            () -> ${className.toLowerCase()}Service.eliminar("id-inexistente"));
        verify(${className.toLowerCase()}Repository, never()).deleteById(anyString());
    }
}
