Time Organiser API
A SpringBoot backend for managing assignments, tasks, goals and hobbies and meeting with new people by syncing your personal calendars.

Features:
User managment: secure registration with password hashing and profile updates
Assignment, goals, tasks and hobbies tracking: track deadlines with days remaining option
Meeting requests: connect with friends and manage meeting requests with status
Search engine: flexible search with filters like name and city

Tech Stack:
Framework: SpringBoot 3.x
Database: PostgreSQL
Security: Spring Security(JWT)
Validation: Jakarta Bean Validation(Hibernate Validator)
Object Mapping: ModelMapper
Build Tool: Maven

Getting started:
Prerequisites: 
Java 17 or higher
Maven 3.6+
PostgreSQL Server

1.Database setup
CREATE DATABASE time_organiser;

2. Configure environment
Update src/main/resources/application.properties with your credentials:

spring.datasource.url=jdbc:postgresql://localhost:5442/time_organiser
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

3. Add maven dependency
   <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
 </dependency>

4. Run the Application
Open your terminal in the root folder and run:

mvn clean install
mvn spring-boot:run

The server will start on http://localhost:8080.



