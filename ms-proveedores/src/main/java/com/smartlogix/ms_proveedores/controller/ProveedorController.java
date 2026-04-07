package com.smartlogix.ms_proveedores.controller;

import com.smartlogix.ms_proveedores.model.Proveedor;
import com.smartlogix.ms_proveedores.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService service;

    @GetMapping
    public List<Proveedor> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtener(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proveedor crear(@RequestBody Proveedor proveedor) {
        return service.guardar(proveedor);
    }
}