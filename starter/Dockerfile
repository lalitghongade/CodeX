# Use the official AdoptOpenJDK base image for Java 17
FROM adoptopenjdk:17-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/your-application.jar app.jar

# Expose the port your Spring Boot application listens on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "app.jar"]
