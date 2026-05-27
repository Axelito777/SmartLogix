package ${package}.service;

import ${package}.dto.${className}Request;
import ${package}.dto.${className}Response;
import ${package}.exception.ResourceNotFoundException;
import ${package}.model.${className};
import ${package}.repository.${className}Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ${className}Service {

    private final ${className}Repository ${className.toLowerCase()}Repository;

    public List<${className}Response> listar() {
        return ${className.toLowerCase()}Repository.findAll()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
    }

    public ${className}Response obtener(String id) {
        ${className} entidad = ${className.toLowerCase()}Repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                    "${className} no encontrado con id: " + id));
        return convertirAResponse(entidad);
    }

    public ${className}Response crear(${className}Request request) {
        ${className} entidad = new ${className}();
        entidad.setNombre(request.getNombre());
        entidad.setDescripcion(request.getDescripcion());
        ${className.toLowerCase()}Repository.save(entidad);
        return convertirAResponse(entidad);
    }

    public ${className}Response actualizar(String id, ${className}Request request) {
        ${className} entidad = ${className.toLowerCase()}Repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                    "${className} no encontrado con id: " + id));
        entidad.setNombre(request.getNombre());
        entidad.setDescripcion(request.getDescripcion());
        ${className.toLowerCase()}Repository.save(entidad);
        return convertirAResponse(entidad);
    }

    public void eliminar(String id) {
        if (!${className.toLowerCase()}Repository.existsById(id)) {
            throw new ResourceNotFoundException(
                "${className} no encontrado con id: " + id);
        }
        ${className.toLowerCase()}Repository.deleteById(id);
    }

    private ${className}Response convertirAResponse(${className} entidad) {
        return new ${className}Response(
                entidad.getId(),
                entidad.getNombre(),
                entidad.getDescripcion(),
                entidad.getCreatedAt()
        );
    }
}
