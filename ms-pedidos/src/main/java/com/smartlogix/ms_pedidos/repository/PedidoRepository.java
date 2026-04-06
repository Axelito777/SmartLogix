package com.smartlogix.ms_pedidos.repository;

import com.smartlogix.ms_pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoRepository
    extends JpaRepository<Pedido, String> {
    List<Pedido> findByClienteId(String clienteId);
    List<Pedido> findByEstado(String estado);
}
