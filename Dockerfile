# Use a base image with Java 11 installed
FROM openjdk:18

# Set the working directory inside the container

ARG jarfile=target/*.jar
# Copy the compiled JAR file from the target directory to the container
COPY ./target/order-management-1.0-SNAPSHOT.jar order-management.jar

# Set the entrypoint command to run the application
CMD ["java", " -jar", "\\order-management.jar"]
