package com.smartlogix.ms_clientes.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.smartlogix.ms_clientes.dto.PedidoResponse;

@FeignClient(name = "ms-pedidos")
public interface PedidosClient {

    @GetMapping("/api/pedidos/cliente/{clienteId}")
    List<PedidoResponse> getPedidosByCliente(@PathVariable String clienteId);
}
