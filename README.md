# Conference Keynotes Microservices

A distributed system built with Spring Boot and Spring Cloud for managing conferences and keynote speakers.

## 📋 Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Technologies](#technologies)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [Database](#database)

## 🎯 Overview

This project implements a microservices architecture for managing conferences and keynote speakers. It demonstrates key microservices patterns including service discovery, API gateway, and centralized configuration management.

## 🏗️ Architecture

The system consists of the following microservices:

### Core Services

- **Config Service** (Port: 8888)
  - Centralized configuration management using Spring Cloud Config Server
  - Native profile for file-based configuration

- **Discovery Service** (Port: 8761)
  - Service registry and discovery using Netflix Eureka
  - Enables dynamic service registration and location

- **Gateway Service** (Port: 8080)
  - API Gateway for routing and load balancing
  - Routes requests to appropriate microservices
  - Built with Spring Cloud Gateway

### Business Services

- **Conference Service** (Port: 8082)
  - Manages conference entities (CRUD operations)
  - RESTful API for conference management
  - MySQL database: `conference_db`

- **Keynote Service** (Port: 8081)
  - Manages keynote speakers and presentations
  - RESTful API for keynote management
  - MySQL database: `keynote_db`

## 🚀 Technologies

- **Java 17+**
- **Spring Boot 3.5.6**
- **Spring Cloud 2025.0.0**
  - Spring Cloud Config
  - Spring Cloud Netflix Eureka
  - Spring Cloud Gateway
- **Spring Data JPA**
- **Spring Data REST**
- **MySQL Database**
- **Maven**
- **Spring Boot Actuator**

## 📦 Prerequisites

Before running this project, ensure you have:

- **JDK 17 or higher** installed
- **Maven 3.6+** installed
- **MySQL Server** running on `localhost:3306`
- MySQL credentials configured (default: root/Glsid@2025)

## 📁 Project Structure

```
conference-keynotes-microservices/
├── config-service/              # Configuration server
│   ├── src/
│   └── pom.xml
├── discovery-service/           # Eureka service registry
│   ├── src/
│   └── pom.xml
├── gateway-service/             # API Gateway
│   ├── src/
│   └── pom.xml
├── conference-service/          # Conference management
│   ├── src/
│   │   └── main/
│   │       └── java/ma/soufiane/conferenceservice/
│   │           ├── controller/
│   │           ├── dto/
│   │           ├── entity/
│   │           ├── mapper/
│   │           ├── repository/
│   │           └── service/
│   └── pom.xml
├── keynote-service/            # Keynote management
│   ├── src/
│   │   └── main/
│   │       └── java/ma/soufiane/keynoteservice/
│   │           ├── controller/
│   │           ├── dto/
│   │           ├── entity/
│   │           ├── mapper/
│   │           ├── repository/
│   │           └── service/
│   └── pom.xml
├── config-repo/                # Configuration repository
├── pom.xml                     # Parent POM
└── README.md
```

## 🎬 Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd conference-keynotes-microservices
```

### 2. Configure Database

Create MySQL databases (or let Spring Boot auto-create them):

```sql
CREATE DATABASE conference_db;
CREATE DATABASE keynote_db;
```

Update database credentials in `application.yml` files if needed.

### 3. Start Services

Services must be started in the following order:

#### Step 1: Start Config Service

```bash
cd config-service
./mvnw spring-boot:run
```

Wait until the service is fully started (available at `http://localhost:8888`)

#### Step 2: Start Discovery Service

```bash
cd discovery-service
./mvnw spring-boot:run
```

Access Eureka Dashboard at `http://localhost:8761`

#### Step 3: Start Gateway Service

```bash
cd gateway-service
./mvnw spring-boot:run
```

The API Gateway will be available at `http://localhost:8080`

#### Step 4: Start Business Services

Start Conference Service:
```bash
cd conference-service
./mvnw spring-boot:run
```

Start Keynote Service:
```bash
cd keynote-service
./mvnw spring-boot:run
```

### 4. Verify Services

Visit the Eureka Dashboard at `http://localhost:8761` to verify all services are registered.

## 🌐 API Endpoints

### Via API Gateway (Recommended)

All requests should go through the Gateway Service:

**Conference Service:**
- Base URL: `http://localhost:8080/api/conferences`
- GET `/api/conferences` - List all conferences
- GET `/api/conferences/{id}` - Get conference by ID
- POST `/api/conferences` - Create new conference
- PUT `/api/conferences/{id}` - Update conference
- DELETE `/api/conferences/{id}` - Delete conference

**Keynote Service:**
- Base URL: `http://localhost:8080/api/keynotes`
- GET `/api/keynotes` - List all keynotes
- GET `/api/keynotes/{id}` - Get keynote by ID
- POST `/api/keynotes` - Create new keynote
- PUT `/api/keynotes/{id}` - Update keynote
- DELETE `/api/keynotes/{id}` - Delete keynote

### Direct Service Access (Development)

- Conference Service: `http://localhost:8082`
- Keynote Service: `http://localhost:8081`

## ⚙️ Configuration

### Config Service

Configuration files are stored in the `config-repo/` directory. The Config Service uses native profile to read configurations from the file system.

Location: `/home/soufiane/Documents/ENSET/s5/distibuted systems/conference-keynotes-microservices/config-repo`

### Service Ports

| Service | Port |
|---------|------|
| Config Service | 8888 |
| Discovery Service | 8761 |
| Gateway Service | 8080 |
| Keynote Service | 8081 |
| Conference Service | 8082 |

## 💾 Database

### Conference Service Database

- Database Name: `conference_db`
- Auto-create: Enabled
- DDL Auto: Update
- Dialect: MySQL

### Keynote Service Database

- Database Name: `keynote_db`
- Auto-create: Enabled
- DDL Auto: Update
- Dialect: MySQL

### Connection Details

```yaml
Host: localhost
Port: 3306
Username: root
Password: Glsid@2025
```
