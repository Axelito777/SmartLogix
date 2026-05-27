# ${artifactId}

Microservicio Spring Boot generado con el arquetipo Smartlogix.

## Tecnologías

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA + PostgreSQL
- Spring Cloud Netflix Eureka Client
- Spring Cloud OpenFeign
- Springdoc OpenAPI (Swagger UI)
- Lombok
- Bean Validation

## Estructura del proyecto

```
src/
├── main/
│   ├── java/${package.replaceAll('\\.', '/')}/
│   │   ├── ${className}Application.java        <- Clase principal
│   │   ├── controller/
│   │   │   └── ${className}Controller.java     <- Endpoints REST
│   │   ├── service/
│   │   │   └── ${className}Service.java        <- Lógica de negocio
│   │   ├── repository/
│   │   │   └── ${className}Repository.java     <- Acceso a datos
│   │   ├── model/
│   │   │   └── ${className}.java               <- Entidad JPA
│   │   ├── dto/
│   │   │   ├── ${className}Request.java        <- DTO de entrada
│   │   │   └── ${className}Response.java       <- DTO de salida
│   │   └── exception/
│   │       ├── GlobalExceptionHandler.java     <- Manejo de errores
│   │       └── ResourceNotFoundException.java  <- Excepción personalizada
│   └── resources/
│       └── application.properties
└── test/
    └── java/${package.replaceAll('\\.', '/')}/
        ├── ${className}ApplicationTests.java
        └── service/
            └── ${className}ServiceTest.java
```

## Configuración

Las variables de entorno requeridas son:

| Variable | Descripción | Default |
|----------|-------------|---------|
| `SPRING_DATASOURCE_URL` | URL de conexión PostgreSQL | `jdbc:postgresql://localhost:5432/${artifactId}` |
| `SPRING_DATASOURCE_USERNAME` | Usuario de BD | `postgres` |
| `SPRING_DATASOURCE_PASSWORD` | Contraseña de BD | `postgres` |
| `EUREKA_CLIENT_SERVICEURL_DEFAULTZONE` | URL de Eureka | `http://localhost:8761/eureka/` |

## Endpoints

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/${className.toLowerCase()}s` | Listar todos |
| GET | `/api/${className.toLowerCase()}s/{id}` | Obtener por ID |
| POST | `/api/${className.toLowerCase()}s` | Crear nuevo |
| PUT | `/api/${className.toLowerCase()}s/{id}` | Actualizar |
| DELETE | `/api/${className.toLowerCase()}s/{id}` | Eliminar |

## Swagger UI

Disponible en: `http://localhost:{port}/swagger-ui.html`

## Ejecución

```bash
mvn spring-boot:run
```

## Tests

```bash
mvn test
```
