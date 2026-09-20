# 🔐 Authentication API

A simple Authentication REST API built using **Java, Spring Boot, Spring Security, Spring Data JPA, and MySQL**.

This project is part of my **50-Day Java + Spring Boot Mini Project Challenge**.

## 🚀 Features

- User Registration
- User Login
- Spring Security Authentication
- MySQL Database Integration
- BCrypt Password Hashing
- Custom `UserDetailsService`
- `DaoAuthenticationProvider`
- `AuthenticationManager`
- Request and Response DTOs
- Input Validation
- Public and Protected Endpoints

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- Jakarta Validation
- Maven

## 📂 Project Structure

```text
src/main/java/com/mini/Authentication
│
├── controller
│   └── UserController.java
│
├── dto
│   ├── RegisterRequest.java
│   ├── RegisterResponse.java
│   └── LoginRequest.java
│
├── model
│   └── User.java
│
├── repository
│   └── UserRepository.java
│
├── security
│   └── SecurityConfig.java
│
└── service
    ├── UserService.java
    └── CustomUserDetailsService.java
```

## 📌 API Endpoints

| Method | Endpoint | Description | Access |
|---|---|---|---|
| POST | `/auth/register` | Register a new user | Public |
| POST | `/auth/login` | Authenticate user | Public |

## 📝 Register User

### Request

```http
POST /auth/register
Content-Type: application/json
```

```json
{
  "username": "madhav",
  "email": "madhav@gmail.com",
  "password": "123456"
}
```

### Response

```json
{
  "id": 1,
  "username": "madhav",
  "email": "madhav@gmail.com"
}
```

The password is encoded using **BCrypt** before being stored in the database.

## 🔑 Login

### Request

```http
POST /auth/login
Content-Type: application/json
```

```json
{
  "username": "madhav",
  "password": "123456"
}
```

### Successful Response

```text
200 OK
```

Spring Security authenticates the username and password using the user stored in MySQL.

## 🔄 Authentication Flow

```text
Login Request
      ↓
UsernamePasswordAuthenticationToken
      ↓
AuthenticationManager
      ↓
DaoAuthenticationProvider
      ↓
CustomUserDetailsService
      ↓
UserRepository
      ↓
MySQL Database
      ↓
UserDetails
      ↓
PasswordEncoder
      ↓
Authentication Success / Failure
```

## 🔒 Password Security

Passwords are never stored as plain text.

```text
Plain Password
      ↓
BCryptPasswordEncoder
      ↓
Hashed Password
      ↓
MySQL Database
```

## 🧠 Concepts Learned

- Spring Security basics
- `SecurityFilterChain`
- `permitAll()` and protected endpoints
- CSRF configuration for REST APIs
- `UserDetails`
- `UserDetailsService`
- Custom `UserDetailsService`
- `DaoAuthenticationProvider`
- `AuthenticationManager`
- `UsernamePasswordAuthenticationToken`
- `PasswordEncoder`
- `BCryptPasswordEncoder`
- Database-based authentication
- Request and Response DTOs
- Jakarta Validation
- Secure password storage

## 🏷️ Challenge

**Day 9/50 — Java + Spring Boot Mini Project Challenge**
