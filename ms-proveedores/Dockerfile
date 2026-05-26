# Stage 1 - Build
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /build

# Copia el pom.xml padre (requerido por <relativePath>../pom.xml</relativePath>)
COPY pom.xml ./

# Copia los archivos del microservicio para cachear dependencias
COPY ms-proveedores/.mvn/ ms-proveedores/.mvn/
COPY ms-proveedores/mvnw ms-proveedores/pom.xml ms-proveedores/
RUN cd ms-proveedores && ./mvnw dependency:go-offline -q

# Copia el código fuente y compila
COPY ms-proveedores/src/ ms-proveedores/src/
RUN cd ms-proveedores && ./mvnw package -DskipTests -q

# Stage 2 - Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Usuario no root
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

COPY --from=builder /build/ms-proveedores/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
