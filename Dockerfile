# Use official Maven image to build the app
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml and download dependencies first (better caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Package the application (skip tests for faster build, remove -DskipTests if you want tests in build)
RUN mvn clean package -DskipTests

# Use a lightweight JRE image for running the app
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose the default Spring Boot port
EXPOSE 8080
