package com.smartlogix.ms_clientes;

import com.smartlogix.ms_clientes.model.Cliente;
import com.smartlogix.ms_clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final ClienteRepository clienteRepository;

    @Override
    public void run(String... args) {
        if (clienteRepository.count() == 0) {
            clienteRepository.save(crearCliente("Juan Pérez", "12345678-9", "juan@smartlogix.com", "912345678", "Av. Principal 123"));
            clienteRepository.save(crearCliente("María López", "98765432-1", "maria@smartlogix.com", "987654321", "Calle Sur 456"));
            clienteRepository.save(crearCliente("Carlos Soto", "11111111-1", "carlos@smartlogix.com", "911111111", "Pasaje Norte 789"));
            System.out.println("✅ Clientes de prueba creados");
        }
    }

    private Cliente crearCliente(String nombre, String rut, String email, String telefono, String direccion) {
        Cliente c = new Cliente();
        c.setNombre(nombre);
        c.setRut(rut);
        c.setEmail(email);
        c.setTelefono(telefono);
        c.setDireccion(direccion);
        return c;
    }
}
