# ms-notificaciones

Microservicio de notificaciones de SmartLogix. Recibe y almacena notificaciones generadas por otros microservicios (ms-pedidos, ms-envios) y las expone para consulta por usuario.

## Puerto

`8088`

## Endpoints

| Método | Ruta | Descripción |
|--------|------|-------------|
| `POST` | `/api/notificaciones/enviar` | Crea y almacena una notificación |
| `GET` | `/api/notificaciones/usuario/{id}` | Lista notificaciones de un usuario por ID |
| `GET` | `/api/notificaciones` | Lista todas las notificaciones |

### Ejemplo de envío

```json
POST /api/notificaciones/enviar
{
  "usuarioId": 42,
  "mensaje": "Tu pedido ha sido creado exitosamente"
}
```

El campo `fechaEnvio` se asigna automáticamente al momento de persistencia.

Todos los endpoints requieren `Authorization: Bearer <token>` (validado por el gateway).

## Swagger UI

Disponible en: `http://localhost:8088/swagger-ui/index.html`

## Ejecución local con Maven

```bash
cd ms-notificaciones
./mvnw spring-boot:run
```

## Ejecución con Docker (desde la raíz de Smartlogix)

```bash
docker-compose up --build ms-notificaciones
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
