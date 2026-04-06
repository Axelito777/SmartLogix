package com.smartlogix.ms_clientes.service;

import com.smartlogix.ms_clientes.dto.ClienteRequest;
import com.smartlogix.ms_clientes.dto.ClienteResponse;
import com.smartlogix.ms_clientes.model.Cliente;
import com.smartlogix.ms_clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.smartlogix.ms_clientes.client.PedidosClient;
import com.smartlogix.ms_clientes.dto.PedidoResponse;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // Listar todos los clientes
    public List<ClienteResponse> listar() {
        return clienteRepository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    // Obtener un cliente por id
    public ClienteResponse obtener(String id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> 
                    new RuntimeException("Cliente no encontrado"));
        return convertirAResponse(cliente);
    }

    // Crear un cliente nuevo
    public ClienteResponse crear(ClienteRequest request) {
        // Verifica que no exista el email
        if (clienteRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }
        // Verifica que no exista el rut
        if (clienteRepository.findByRut(request.getRut()).isPresent()) {
            throw new RuntimeException("El rut ya está registrado");
        }

        Cliente cliente = new Cliente();
        cliente.setNombre(request.getNombre());
        cliente.setRut(request.getRut());
        cliente.setEmail(request.getEmail());
        cliente.setTelefono(request.getTelefono());
        cliente.setDireccion(request.getDireccion());

        clienteRepository.save(cliente);
        return convertirAResponse(cliente);
    }

    // Actualizar un cliente
    public ClienteResponse actualizar(String id, ClienteRequest request) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> 
                    new RuntimeException("Cliente no encontrado"));

        cliente.setNombre(request.getNombre());
        cliente.setEmail(request.getEmail());
        cliente.setTelefono(request.getTelefono());
        cliente.setDireccion(request.getDireccion());

        clienteRepository.save(cliente);
        return convertirAResponse(cliente);
    }

    // Convierte Cliente a ClienteResponse
    private ClienteResponse convertirAResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getRut(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getDireccion(),
                cliente.getCreatedAt()
        );
    }
    private final PedidosClient pedidosClient;
    public List<PedidoResponse> getPedidosByCliente(String clienteId) {
    // Verifica que el cliente existe
    clienteRepository.findById(clienteId)
            .orElseThrow(() -> 
                new RuntimeException("Cliente no encontrado"));
    
    return pedidosClient.getPedidosByCliente(clienteId);
}
}
