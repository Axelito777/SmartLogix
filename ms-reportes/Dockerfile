# Stage 1 - Build
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /build

# Copia el pom.xml padre (requerido por <relativePath>../pom.xml</relativePath>)
COPY pom.xml ./

# Copia los archivos del microservicio para cachear dependencias
COPY ms-reportes/.mvn/ ms-reportes/.mvn/
COPY ms-reportes/mvnw ms-reportes/pom.xml ms-reportes/
RUN cd ms-reportes && ./mvnw dependency:go-offline -q

# Copia el código fuente y compila
COPY ms-reportes/src/ ms-reportes/src/
RUN cd ms-reportes && ./mvnw package -DskipTests -q

# Stage 2 - Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Usuario no root
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

COPY --from=builder /build/ms-reportes/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
