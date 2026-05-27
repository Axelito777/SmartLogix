package ${package}.repository;

import ${package}.model.${className};
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ${className}Repository extends JpaRepository<${className}, String> {

    Optional<${className}> findByNombre(String nombre);
}
