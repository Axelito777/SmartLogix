package com.smartlogix.ms_clientes.repository;

import com.smartlogix.ms_clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepository 
    extends JpaRepository<Cliente, String> {
    Optional<Cliente> findByEmail(String email);
    Optional<Cliente> findByRut(String rut);
}