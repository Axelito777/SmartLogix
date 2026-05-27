# Stage 1 - Build
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /build

# Copia el pom.xml padre (requerido por <relativePath>../pom.xml</relativePath>)
COPY pom.xml ./

# Copia los archivos del microservicio para cachear dependencias
COPY ms-notificaciones/.mvn/ ms-notificaciones/.mvn/
COPY ms-notificaciones/mvnw ms-notificaciones/pom.xml ms-notificaciones/
RUN cd ms-notificaciones && ./mvnw dependency:go-offline -q

# Copia el código fuente y compila
COPY ms-notificaciones/src/ ms-notificaciones/src/
RUN cd ms-notificaciones && ./mvnw package -DskipTests -q

# Stage 2 - Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Usuario no root
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

COPY --from=builder /build/ms-notificaciones/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
