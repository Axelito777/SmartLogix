package com.smartlogix.ms_pagos.repository;

import com.smartlogix.ms_pagos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Consulta personalizada para buscar por el ID del pedido
    Optional<Pago> findByPedidoId(Long pedidoId);
}