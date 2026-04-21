package ms_proveedores.controller;

import ms_proveedores.entity.Proveedor;
import ms_proveedores.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(proveedorService.guardarProveedor(proveedor));
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> obtenerProveedores() {
        return ResponseEntity.ok(proveedorService.obtenerTodos());
    }
}