📏 Quantity Measurement App
Java Spring Boot Spring Data JPA Hibernate H2 MySQL JUnit5 Mockito License

A Spring Boot REST API for performing Quantity Measurement, Unit Conversion, Comparison, and Arithmetic Operations using clean architecture and object-oriented design principles.

📖 Overview
The Quantity Measurement App is a RESTful web application built using Spring Boot that allows users to compare, convert, and perform arithmetic operations on different measurement units.

The application supports multiple measurement types such as:

📏 Length
⚖ Weight
🌡 Temperature
🧪 Volume
It also stores operation history in a database and exposes REST APIs for performing calculations and retrieving historical records.

🚀 Features
✅ Compare Quantities
✅ Add Quantities
✅ Unit Conversion
✅ Operation History
✅ Operation Count
✅ H2 Database Support
✅ MySQL Support
✅ REST APIs
✅ Spring Data JPA
✅ Hibernate ORM
✅ Global Exception Handling
✅ DTO Based Architecture
✅ Layered Architecture
✅ Swagger/OpenAPI Documentation
✅ Unit Testing
✅ Mockito Testing
✅ MockMvc Controller Testing
🏗 Project Architecture
Client

                      │
                      ▼

          QuantityMeasurementController

                      │
                      ▼

         QuantityMeasurementService

                      │
                      ▼

      QuantityMeasurementRepository

                      │
                      ▼

            H2 / MySQL Database
📂 Project Structure
QuantityMeasurementApp
│
├── src
│
├── controller
│     └── QuantityMeasurementController.java
│
├── service
│     ├── IQuantityMeasurementService.java
│     └── QuantityMeasurementService.java
│
├── repository
│     └── QuantityMeasurementRepository.java
│
├── dto
│     ├── QuantityDTO.java
│     ├── QuantityInputDTO.java
│     └── QuantityMeasurementDTO.java
│
├── entity
│     └── QuantityMeasurement.java
│
├── enums
│     ├── LengthUnit.java
│     ├── WeightUnit.java
│     ├── VolumeUnit.java
│     └── TemperatureUnit.java
│
├── exception
│     ├── GlobalExceptionHandler.java
│     └── QuantityMeasurementException.java
│
├── util
│     └── UnitConverter.java
│
├── config
│     └── SwaggerConfig.java
│
├── resources
│     ├── application.properties
│     └── data.sql
│
└── QuantityMeasurementApplication.java
📐 Supported Measurement Types
Length
Feet
Inch
Yard
Centimeter
Meter
Kilometer
Weight
Gram
Kilogram
Ton
Volume
Milliliter
Liter
Gallon
Temperature
Celsius
Fahrenheit
Kelvin
📡 REST APIs
Compare Quantities
POST
/api/v1/quantities/compare
Request
{
"thisQuantityDTO": {
"value": 1,
"unit": "FEET",
"measurementType": "LengthUnit"
},
"thatQuantityDTO": {
"value": 12,
"unit": "INCHES",
"measurementType": "LengthUnit"
}
}
Response
{
"thisValue": 1,
"thisUnit": "FEET",
"thatValue": 12,
"thatUnit": "INCHES",
"operation": "compare",
"resultString": "true",
"error": false
}
Add Quantities
POST
/api/v1/quantities/add
Request
{
"thisQuantityDTO": {
"value": 1,
"unit": "FEET",
"measurementType": "LengthUnit"
},
"thatQuantityDTO": {
"value": 12,
"unit": "INCHES",
"measurementType": "LengthUnit"
}
}
Response
{
"operation": "add",
"resultValue": 2,
"resultUnit": "FEET",
"error": false
}
Get Operation History
GET
/api/v1/quantities/history/operation/{operation}
Example

GET /api/v1/quantities/history/operation/compare
Get Operation Count
GET
/api/v1/quantities/count/{operation}
Example

GET /api/v1/quantities/count/COMPARE
💾 Database
H2 Database
Console

http://localhost:8080/h2-console
Configuration

JDBC URL:
jdbc:h2:mem:testdb

Username:
sa

Password:
MySQL
Example

spring.datasource.url=jdbc:mysql://localhost:3306/quantity_measurement

spring.datasource.username=root

spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=update
📖 Swagger Documentation
Swagger UI

http://localhost:8080/swagger-ui/index.html
OpenAPI

http://localhost:8080/v3/api-docs
🧪 Testing
The project includes

Unit Testing
Service Testing
Controller Testing
Integration Testing
Mockito
MockMvc
Example Test Classes

QuantityMeasurementControllerTest

QuantityMeasurementServiceTest
🎯 Concepts Covered
Core Java
Classes
Objects
Encapsulation
Polymorphism
Inheritance
Abstraction
Enum
Exception Handling
Spring Boot
REST APIs
Spring MVC
Dependency Injection
Bean Validation
Controller Advice
Spring Data JPA
Repository Pattern
Entity Mapping
CRUD Operations
Hibernate
ORM
Persistence
Auto Table Creation
REST API Concepts
GET
POST
JSON Request
JSON Response
HTTP Status Codes
Testing
JUnit 5
Mockito
MockMvc
Assertions
Integration Testing
Design Patterns
Layered Architecture
DTO Pattern
Repository Pattern
Strategy Pattern
Factory Pattern
Dependency Injection
▶️ Running the Project
Clone Repository
git clone https://github.com/BL-Anbu/QuantityMeasurementApp.git
Open Project
Open using IntelliJ IDEA or Eclipse.

Build Project
mvn clean install
Run Application
mvn spring-boot:run
Or run

QuantityMeasurementApplication.java
📈 Learning Outcomes
This project demonstrates

Spring Boot REST API Development
Layered Architecture
Spring Data JPA
Hibernate ORM
DTO Design
Unit Conversion Logic
Object-Oriented Programming
Exception Handling
Unit Testing
Mockito
MockMvc
Clean Code Practices
🚀 Future Enhancements
JWT Authentication
Spring Security
Docker
Redis Cache
PostgreSQL Support
Kafka Event Streaming
GraphQL APIs
Kubernetes Deployment
Unit Conversion Dashboard
Microservices Architecture
🤝 Contributing
Contributions are welcome!

Fork Repository
git fork
Create Branch
git checkout -b feature/new-feature
Commit
git commit -m "Added new feature"
Push
git push origin feature/new-feature
Create Pull Request
👨‍💻 Author
Anbarasu A
Java Full Stack Developer

Skills
Java
Spring Boot
Spring Data JPA
Hibernate
MySQL
REST APIs
Microservices
Docker
GitHub

https://github.com/BL-Anbu
⭐ Show Your Support
If you found this project useful, consider giving it a ⭐ Star on GitHub.

📄 License
This project is licensed under the MIT License.

Developed for learning, practice, and educational purposes.