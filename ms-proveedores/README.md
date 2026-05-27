# ms-proveedores

Microservicio de gestión de proveedores de SmartLogix. Permite el alta, consulta, actualización y eliminación de proveedores que abastecen el inventario.

## Puerto

`8086`

## Endpoints

| Método | Ruta | Descripción |
|--------|------|-------------|
| `GET` | `/api/proveedores` | Lista todos los proveedores |
| `GET` | `/api/proveedores/{id}` | Obtiene un proveedor por ID |
| `POST` | `/api/proveedores` | Crea un nuevo proveedor |
| `PUT` | `/api/proveedores/{id}` | Actualiza datos de un proveedor |
| `DELETE` | `/api/proveedores/{id}` | Elimina un proveedor |

### Ejemplo de creación

```json
POST /api/proveedores
{
  "nombre": "Distribuidora ABC Ltda.",
  "email": "ventas@abc.cl",
  "telefono": "+56222345678",
  "direccion": "Av. Industrial 456, Santiago"
}
```

El campo `email` es opcional pero, si se proporciona, debe tener formato de correo electrónico válido.

Todos los endpoints requieren `Authorization: Bearer <token>` (validado por el gateway).

## Swagger UI

Disponible en: `http://localhost:8086/swagger-ui/index.html`

## Ejecución local con Maven

```bash
cd ms-proveedores
./mvnw spring-boot:run
```

## Ejecución con Docker (desde la raíz de Smartlogix)

```bash
docker-compose up --build ms-proveedores
```

## Variables de configuración (`application.yml`)

| Variable | Descripción | Valor por defecto |
|----------|-------------|-------------------|
| `SPRING_DATASOURCE_URL` | URL de conexión PostgreSQL | Supabase pooler |
| `SPRING_DATASOURCE_USERNAME` | Usuario de base de datos | `postgres.gkcyyzzaizzuglmyetpe` |
| `SPRING_DATASOURCE_PASSWORD` | Contraseña de base de datos | — |
| `EUREKA_CLIENT_SERVICEURL_DEFAULTZONE` | URL del servidor Eureka | `http://localhost:8761/eureka/` |

## Dependencias principales

- Spring Boot 3.2.0
- Spring Data JPA + PostgreSQL
- Spring Cloud Netflix Eureka Client
- Spring Validation
- Springdoc OpenAPI (Swagger)
