# syntax=docker/dockerfile:1

################################################################################
# Stage 1: Build the application with Gradle
################################################################################
FROM gradle:8.8-jdk21 AS build

# Set working directory
WORKDIR /app

# Copy Gradle files first for dependency caching
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle gradle

# Download dependencies
RUN ./gradlew dependencies --no-daemon || return 0

# Copy the rest of the source code
COPY . .

# Build the Spring Boot fat jar (skip tests to speed up build)
RUN ./gradlew bootJar --no-daemon -x test

################################################################################
# Stage 2: Run the application with minimal JRE
################################################################################
FROM eclipse-temurin:21-jre-jammy AS runtime

# Create a non-root user
ARG UID=10001
RUN adduser \
    --disabled-password \
    --gecos "" \
    --home "/nonexistent" \
    --shell "/sbin/nologin" \
    --no-create-home \
    --uid "${UID}" \
    appuser
USER appuser

# Copy built jar from previous stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose app port
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
