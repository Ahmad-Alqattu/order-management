# order-management

Building the Application:
To build the application using IntelliJ IDEA and Maven, follow these steps:

Clone the Git repository using the following command:

bash
Copy code
git clone https://github.com/Ahmad-Alqattu/order-management.git
Open IntelliJ IDEA and select "Open" from the main menu.

Navigate to the directory where you cloned the repository and select the project.

Wait for IntelliJ IDEA to import the project and resolve dependencies.

Open a terminal within IntelliJ IDEA and run the following command to build the application:

go
Copy code
mvn clean package
This will compile the source code, run tests, and package the application into a JAR file.

After a successful build, the JAR file will be created in the target directory.

Creating and Running the Docker Image:
To create and run the Docker image of the application, follow these steps:

Make sure Docker is installed and running on your machine.

Open a terminal or command prompt.

Navigate to the project directory (order-management).

Build the Docker image using the following command:

css
Copy code
docker build -t order-management .
This command will create a Docker image named "order-management" using the Dockerfile in the project directory.

Once the image is built successfully, you can run the Docker container using the following command:

arduino
Copy code
docker run -p 8080:8080 order-management
This command starts a container from the "order-management" image and maps port 8080 of the container to port 8080 of the host machine.

The application should now be running in the Docker container. You can access the Swagger documentation at http://localhost:8080/swagger-ui/.

Please note that you may need to adjust the Docker commands based on your specific environment and configuration.
