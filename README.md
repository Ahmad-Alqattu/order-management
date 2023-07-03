# Order Management Application

This is an Order Management application developed using Spring Boot. It allows you to manage orders, customers, and products.

## Getting Started

To get started with the application, follow the steps below.

### Prerequisites

- Java JDK 11 or later
- Apache Maven
- Docker (optional, for creating and running a Docker image)

### Clone the Repository

```bash
git clone https://github.com/Ahmad-Alqattu/order-management.git
Build the Application
Open IntelliJ IDEA and select "Open" from the main menu. Navigate to the directory where you cloned the repository and select the project. Wait for IntelliJ IDEA to import the project and resolve dependencies.

Open a terminal within IntelliJ IDEA and run the following command to build the application:

bash
Copy code
mvn clean package
This will compile the source code, run tests, and package the application into a JAR file.

Running the Application
You can run the application directly using Maven:

bash
Copy code
mvn spring-boot:run
Alternatively, you can run the JAR file:

bash
Copy code
java -jar target/order-management.jar
The application will be accessible at http://localhost:8080.

Swagger Documentation
You can access the Swagger documentation at http://localhost:8080/swagger-ui/.

Docker Image
To create and run a Docker image of the application, follow the steps below.

Build the Docker Image
Make sure Docker is installed and running on your machine.

Open a terminal or command prompt.

Navigate to the project directory (order-management).

Build the Docker image using the following command:

bash
Copy code
docker build -t order-management .
This command will create a Docker image named "order-management" using the Dockerfile in the project directory.

Running the Docker Container
Once the image is built successfully, you can run the Docker container using the following command:

bash
Copy code
docker run -p 8080:8080 order-management
This command starts a container from the "order-management" image and maps port 8080 of the container to port 8080 of the host machine.

The application should now be running in the Docker container. You can access the Swagger documentation at http://localhost:8080/swagger-ui/.
