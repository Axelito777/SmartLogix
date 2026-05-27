# ms-envios

Microservicio de gestión de envíos de SmartLogix. Crea envíos asociados a pedidos, genera tracking numbers automáticamente y notifica al cliente vía ms-notificaciones.

## Puerto

`8085`

## Endpoints

| Método | Ruta | Descripción |
|--------|------|-------------|
| `POST` | `/api/envios/crear` | Crea un nuevo envío para un pedido |
| `GET` | `/api/envios` | Lista todos los envíos |
| `GET` | `/api/envios/{id}` | Obtiene un envío por ID |

### Ejemplo de creación

```json
POST /api/envios/crear
{
  "pedido_id": "uuid-del-pedido",
  "transportista": "Chilexpress"
}
```

El campo `trackingNumber` se genera automáticamente (8 caracteres aleatorios en mayúsculas). El estado inicial es `PREPARANDO`.

Todos los endpoints requieren `Authorization: Bearer <token>` (validado por el gateway).

## Swagger UI

Disponible en: `http://localhost:8085/swagger-ui/index.html`

## Ejecución local con Maven

```bash
cd ms-envios
./mvnw spring-boot:run
```

## Ejecución con Docker (desde la raíz de Smartlogix)

```bash
docker-compose up --build ms-envios
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
- Spring Cloud OpenFeign (notificaciones)
- Springdoc OpenAPI (Swagger)
