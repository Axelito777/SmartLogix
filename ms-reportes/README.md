# ms-reportes

Microservicio de reportes y analítica de SmartLogix. Agrega datos de ms-pedidos y ms-inventario para generar reportes de ventas e inventario en tiempo real, sin base de datos propia.

## Puerto

`8089`

## Endpoints

| Método | Ruta | Descripción |
|--------|------|-------------|
| `GET` | `/api/reportes/ventas` | Reporte de ventas: totales, completados, pendientes y ticket promedio |
| `GET` | `/api/reportes/inventario` | Reporte de inventario: total de productos, bajo stock y valor total |

### Respuesta de reporte de ventas

```json
GET /api/reportes/ventas
{
  "totalPedidos": 150,
  "pedidosCompletados": 120,
  "pedidosPendientes": 30,
  "totalRecaudado": 18500000.00,
  "ticketPromedio": 154166.67
}
```

### Respuesta de reporte de inventario

```json
GET /api/reportes/inventario
{
  "totalProductos": 85,
  "productosBajoStock": 7,
  "valorTotalInventario": 4250000.00
}
```

Un producto se considera bajo stock cuando `stock <= stockMinimo`.

Todos los endpoints requieren `Authorization: Bearer <token>` (validado por el gateway).

## Swagger UI

Disponible en: `http://localhost:8089/swagger-ui/index.html`

## Ejecución local con Maven

```bash
cd ms-reportes
./mvnw spring-boot:run
```

## Ejecución con Docker (desde la raíz de Smartlogix)

```bash
docker-compose up --build ms-reportes
```

## Variables de configuración (`application.yml`)

| Variable | Descripción | Valor por defecto |
|----------|-------------|-------------------|
| `SPRING_DATASOURCE_URL` | URL de conexión PostgreSQL (no usada activamente) | Supabase pooler |
| `SPRING_DATASOURCE_USERNAME` | Usuario de base de datos | `postgres.gkcyyzzaizzuglmyetpe` |
| `SPRING_DATASOURCE_PASSWORD` | Contraseña de base de datos | — |
| `EUREKA_CLIENT_SERVICEURL_DEFAULTZONE` | URL del servidor Eureka | `http://localhost:8761/eureka/` |

## Notas

- Este servicio no tiene base de datos propia: todos los datos los obtiene de ms-pedidos y ms-inventario a través de Feign Clients en cada petición.
- Requiere que ms-pedidos y ms-inventario estén registrados en Eureka para resolver los nombres de servicio.

## Dependencias principales

- Spring Boot 3.2.0
- Spring Data JPA + PostgreSQL
- Spring Cloud Netflix Eureka Client
- Spring Cloud OpenFeign (ms-pedidos, ms-inventario)
- Springdoc OpenAPI (Swagger)
