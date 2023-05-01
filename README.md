# JWT Refresh-Token
Spring 6 Boot 3 - Refresh Token with JWT

## Features!
* Appropriate Flow for User Signup & User Login with JWT Authentication
* Spring Boot Application Architecture with Spring Security
* How to configure Spring Security to work with JWT
* JWT Refresh Token. Expire the JWT, then renew the Access Token with Refresh Token.
* How to define Data Models and association for Authentication and Authorization
* Way to use Spring Data JPA to interact with PostgreSQL Database

### Technology
* JDK 17 or later
* Spring 6.0.8
* Spring Security 6.0.3
* Spring JDBC 6.0.8
* Spring Boot 3.0.6
* Maven 3.0 or later
* PostgreSQL Database
* jjwt 0.11.5
* Lombok-1.18.26
* Git

#### DB Script 
```
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
