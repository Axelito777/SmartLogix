package ${package}.controller;

import ${package}.dto.${className}Request;
import ${package}.dto.${className}Response;
import ${package}.service.${className}Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/${className.toLowerCase()}s")
@RequiredArgsConstructor
public class ${className}Controller {

    private final ${className}Service ${className.toLowerCase()}Service;

    @GetMapping
    public ResponseEntity<List<${className}Response>> listar() {
        return ResponseEntity.ok(${className.toLowerCase()}Service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<${className}Response> obtener(@PathVariable String id) {
        return ResponseEntity.ok(${className.toLowerCase()}Service.obtener(id));
    }

    @PostMapping
    public ResponseEntity<${className}Response> crear(
            @Valid @RequestBody ${className}Request request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(${className.toLowerCase()}Service.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<${className}Response> actualizar(
            @PathVariable String id,
            @Valid @RequestBody ${className}Request request) {
        return ResponseEntity.ok(${className.toLowerCase()}Service.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        ${className.toLowerCase()}Service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
