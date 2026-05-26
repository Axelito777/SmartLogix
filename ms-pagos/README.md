# ms-pagos

Microservicio de procesamiento de pagos de SmartLogix. Registra y gestiona los pagos asociados a pedidos, soportando consulta por pedido o por ID de pago.

## Puerto

`8087`

## Endpoints

| Método | Ruta | Descripción |
|--------|------|-------------|
| `POST` | `/api/pagos/procesar` | Procesa y registra un nuevo pago |
| `GET` | `/api/pagos/{id}` | Obtiene un pago por ID |
| `GET` | `/api/pagos/pedido/{pedidoId}` | Lista todos los pagos de un pedido |
| `GET` | `/api/pagos` | Lista todos los pagos |

### Ejemplo de procesamiento

```json
POST /api/pagos/procesar
{
  "pedidoId": 1001,
  "monto": 75000.00,
  "metodoPago": "TARJETA"
}
```

El estado se establece automáticamente como `PROCESADO` al crear el pago.

Todos los endpoints requieren `Authorization: Bearer <token>` (validado por el gateway).

## Swagger UI

Disponible en: `http://localhost:8087/swagger-ui/index.html`

## Ejecución local con Maven

```bash
cd ms-pagos
./mvnw spring-boot:run
```

## Ejecución con Docker (desde la raíz de Smartlogix)

```bash
docker-compose up --build ms-pagos
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
