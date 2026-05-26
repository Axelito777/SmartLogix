SmartLogix
SmartLogix es un ecosistema backend basado en una arquitectura de microservicios desarrollada en Java, diseñada para ser escalable, modular y fácil de desplegar. El proyecto implementa patrones de diseño clave para sistemas distribuidos, garantizando el descubrimiento de servicios, enrutamiento dinámico y la separación de responsabilidades de negocio.

Arquitectura del Sistema
El proyecto está dividido en componentes de infraestructura y microservicios de negocio:

Componentes de Infraestructura
ms-eureka: Servidor de descubrimiento de servicios (Netflix Eureka) que registra dinámicamente las instancias de cada microservicio.

ms-gateway: Puerta de enlace de la aplicación (Spring Cloud Gateway) que centraliza el enrutamiento de las peticiones de los clientes, la seguridad y el balanceo de carga.

Microservicios de Negocio
ms-inventario: Gestión y control de stock, productos y almacenes.

ms-notificaciones: Servicio asíncrono para el envío de alertas, correos o mensajes internos.

ms-pagos: Procesamiento, validación y registro de transacciones financieras.

ms-pedidos: Gestión del ciclo de vida de las órdenes de compra y solicitudes de clientes.

ms-proveedores: Administración del catálogo de proveedores, contratos y reabastecimiento.

ms-reportes: Motor de análisis de datos y generación de métricas del sistema.

Tecnologías Utilizadas
Lenguaje Principal: Java (Spring Boot y Spring Cloud).

Contenedores e Infraestructura: Docker (Dockerfiles individuales por servicio).

Orquestación Local: Docker Compose para el despliegue unificado de todo el entorno.

Calidad de Código y Cobertura: JaCoCo integrado en el flujo de construcción para auditar de forma automática la cobertura de pruebas unitarias y asegurar la estabilidad ante futuras refactorizaciones.

Despliegue y Ejecución
El proyecto incluye una configuración unificada mediante Docker Compose, lo que permite levantar todo el ecosistema con un solo comando.

Requisitos Previos
Java 17 o superior instalado.

Docker y Docker Compose instalados y en ejecución.

Pasos para Ejecutar
Clona el repositorio:
git clone https://github.com/Axelito777/SmartLogix.git
cd SmartLogix

Compila el proyecto y genera los artefactos (ejecutando la suite de pruebas y la verificación de cobertura con JaCoCo):
./mvnw clean package

Levanta todos los servicios e infraestructura con Docker Compose:
docker-compose up --build -d

Verifica que los servicios estén arriba accediendo al panel de Eureka en http://localhost:8761

Calidad y Pruebas (JaCoCo)
Para este proyecto se implementó JaCoCo directamente en el flujo de construcción y pruebas. La herramienta analiza qué líneas y ramas de decisión se ejecutan durante los tests, identificando zonas ciegas en el código antes de que pasen a fases posteriores de despliegue. Esto asegura que cada microservicio mantenga un umbral alto de cobertura, confiabilidad y estabilidad a largo plazo.
