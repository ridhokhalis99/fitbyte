# --- Build stage ---
FROM gradle:8.10.2-jdk21-alpine AS build
WORKDIR /app
COPY . .
RUN gradle clean bootJar --no-daemon

# --- Runtime stage ---
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
ENV JAVA_OPTS="-XX:MaxRAMPercentage=75.0"
COPY --from=build /app/build/libs/*-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]