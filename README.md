Speaking Clock Application
Overview
The Speaking Clock application is a Spring Boot microservice that provides an API for converting the current time or a given time into a spoken format. It includes robust error handling for invalid time formats and general exceptions.

Features
Current Time Conversion: Converts the system's current time into a spoken format.
Custom Time Conversion: Converts a user-specified time (in HH:mm format) into a spoken format.
Exception Handling: Manages invalid time formats and unexpected errors gracefully.
Technologies
Java: 8
Spring Boot: Framework for building the application
Maven: Build and dependency management
Swagger: API documentation
JUnit 5: Testing framework
Project Structure
src/main/java/com/wisdom/speaking_clock: Contains main application code:
SpeakingClockApplication.java: Main Spring Boot application class
controller: Controllers for handling HTTP requests
service: Business logic for time conversion
exception: Custom exceptions and global exception handler
src/test/java/com/wisdom/speaking_clock: Contains test cases:
controller: Tests for controllers
service: Tests for service layer
exception: Tests for exception handling
pom.xml: Maven build configuration file
src/main/resources/application.properties: Application configuration
Build and Run
Prerequisites
Java 8 or above
Maven (version 3.6.0 or above)
Build the Project
Clone the repository:

git clone https://github.com/veerana246/speaking-clock.git
cd speaking-clock
Build the project using Maven:

mvn clean install
Run the Application
Run the application using Maven:

mvn spring-boot:run
The application will start on port 8081 I have used.

API Endpoints
Get Current Time
Endpoint: /api/time/current
Method: GET
Description: Returns the current system time in a spoken format.
Convert Time
Endpoint: /api/time/convert
Method: GET
Query Parameter: time (Format: HH:mm)
Description: Converts the specified time into a spoken format.
Example: /api/time/convert?time=11:25

Swagger Documentation
Swagger is used to document the API. Once the application is running, you can access the Swagger UI at:
http://localhost:8081/swagger-ui.html
Exception Handling
Invalid Time Format: Returns 400 Bad Request with a message for invalid time formats.
General Exception: Returns 500 Internal Server Error with a generic error message for unexpected errors.
Running Tests
Maven
To run the unit and integration tests, use the following Maven command:

mvn test
Example Test Cases
Exception Handling Tests: Verify that the application returns appropriate error messages for invalid time formats and general exceptions.
Controller Tests: Ensure that the API endpoints return correct responses based on different inputs.

Contact
For any questions or issues, please contact veerana246@gmail.com
