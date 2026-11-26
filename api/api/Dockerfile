
# ----- Stage 1: Build the application -----
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy Maven files first
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Download dependencies
RUN chmod +x mvnw && ./mvnw -q -B dependency:go-offline

# Copy source code
COPY src src

# Build the application
RUN ./mvnw -q -B package -DskipTests && cp target/*.jar app.jar


# ----- Stage 2: Run the application -----
FROM eclipse-temurin:21-jre

WORKDIR /app

# Create a non-root user
RUN useradd --system --no-create-home switchly

USER switchly

# Copy JAR from build stage
COPY --from=build /app/app.jar app.jar

# Expose application port
EXPOSE 8080

# Run Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
