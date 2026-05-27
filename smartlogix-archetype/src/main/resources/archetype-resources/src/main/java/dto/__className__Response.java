package ${package}.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ${className}Response {

    private String id;
    private String nombre;
    private String descripcion;
    private LocalDateTime createdAt;
}
