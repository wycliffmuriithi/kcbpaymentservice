# Use official OpenJDK image as a base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/paymentservice-0.0.1-SNAPSHOT.jar /app/paymentservice.jar

# Expose the application port
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "paymentservice.jar"]
