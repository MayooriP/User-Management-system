# User Management System

## Description

The **User Management System** is a web application built using **Java**, **Spring Boot**, **JDBC**, and **SQL**.
It allows administrators to manage user data, perform CRUD operations.

### Features

- User Registration and Authentication
- View, Add, Update, and Delete User Information
- SQL-based database interactions using JDBC
- RESTful API support for interacting with the application

## Technologies Used

- **Java**: Backend development.
- **Spring Boot**: Framework for simplifying Spring-based applications.
- **Spring Framework**: Dependency Injection, MVC, etc.
- **JDBC**: For database connectivity.
- **SQL**: Relational database for storing user and video data.
- **HTML/CSS**: Frontend (optional for a web-based interface).
- **Postman**: For API testing.

## Setup

### Prerequisites

- **Java 8+**
- **Maven** for dependency management
- **MySQL/PostgreSQL** (or any SQL database)
- **Spring Boot**
- **IDE** (IntelliJ IDEA, Eclipse, etc.)
- **Postman** (for API testing)

### Installation Steps

1. **Clone the repository:**
   ```bash
   git clone https://github.com/MayooriP/User-Management-system.git
## Navigate to the project directory:
cd User-Management-System

## Configure the database: 
Open src/main/resources/application.properties and update the database details:

## properties

spring.datasource.url=jdbc:mysql://localhost:3306/userdb
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

## Build and run the project:
mvn spring-boot:run

## Access the application: 
Open http://localhost:8080 in your browser or use Postman for API testing.

## API Endpoints
GET /users - Get all users
POST /users - Create a new user
GET /users/{id} - Get a specific user by ID
PUT /users/{id} - Update a user's information
DELETE /users/{id} - Delete a user
POST /users/{userId}/videos - Add a video URL to a user profile

