# --- Этап 1: Сборка JAR внутри Docker ---
FROM maven:3.9-eclipse-temurin-21-alpine AS build-env
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# --- Этап 2: Финальный образ для запуска ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /application

# Создаем безопасного non-root пользователя
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Копируем готовый JAR файл из этапа сборки
COPY --from=build-env /build/target/*.jar app.jar

# Тюнинг JVM для работы в контейнере
ENV JAVA_OPTS="-XX:+UseG1GC \
               -XX:MaxRAMPercentage=75.0 \
               -XX:InitialRAMPercentage=50.0 \
               -XX:+ExitOnOutOfMemoryError \
               -Dfile.encoding=UTF-8 \
               -Djava.security.egd=file:/dev/./urandom"

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
