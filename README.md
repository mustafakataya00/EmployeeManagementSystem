TaskOnHrDB Project
--
TaskOnHrDB is a Java-based web application designed for managing employees and departments. This project utilizes Spring Boot for the backend, integrating with MySQL for relational database operations and PL/SQL for stored procedures.

Features
--

**Employee Management**


Create Employee: Add new employees with their name, salary, address, phone number, and department.
Update Employee: Modify existing employee details, including name, salary, address, phone number, and department.
Delete Employee: Remove an employee from the database.
Get All Employees: Retrieve a list of all employees.

**Department Management**


Get All Departments: Fetch a list of all departments available in the organization.

**PL/SQL Integration**


Stored Procedures: Utilize PL/SQL stored procedures for complex database operations.
Integration with JdbcTemplate: Perform database queries and updates using Spring's JdbcTemplate.

**Error Handling**


Custom Exceptions: Handle specific exceptions such as AlreadyExistsException and NotFoundException for robust error management.
Error Responses: Return clear error messages to API clients for better debugging and user feedback.

**Security**

Spring Security: Implement basic authentication using Spring Security for securing API endpoints.
Authorization: Restrict access to certain endpoints based on user roles.

REST API


Employee Controller: Expose RESTful endpoints for CRUD operations on employees.
Department Controller: Provide endpoints to retrieve departments and associated data.
PLSQL Employee Controller: Implement controllers specifically for interacting with PL/SQL procedures.

**Technologies Used**



Java: Programming language for the backend logic.
Spring Boot: Framework for creating robust, scalable applications.
Spring Data JPA: Simplifies data access and persistence with Hibernate.
MySQL: Relational database management system for storing data.
PL/SQL: Oracle's procedural language extension for SQL.
Spring Security: Provides authentication and authorization capabilities.
JdbcTemplate: Simplifies JDBC coding and integrates with Spring applications.

**Project Structure**


The project is structured into several packages:

Models: Defines entities like Employee and Department.
Repositories: Contains Spring Data JPA repositories for database access.
Services: Implements business logic, including CRUD operations and error handling.
Controllers: Provides RESTful endpoints to interact with the application.
PLSQLServices: Handles integration with PL/SQL procedures and JdbcTemplate.
ErrorHandlers: Defines custom exceptions and error response classes.
