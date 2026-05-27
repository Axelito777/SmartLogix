package com.smartlogix.ms_pagos.repository;

import com.smartlogix.ms_pagos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio JPA para la entidad {@link com.smartlogix.ms_pagos.model.Pago}.
 * <p>
 * Hereda operaciones CRUD de {@link JpaRepository} y añade búsqueda por pedido.
 * </p>
 *
 * @author SmartLogix Team
 */
@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    /**
     * Retorna todos los pagos asociados a un pedido.
     *
     * @param pedidoId identificador numérico del pedido
     * @return lista de pagos del pedido; vacía si no tiene pagos registrados
     */
    List<Pago> findByPedidoId(Long pedidoId);
}