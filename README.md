# 🛍️ Item Service — REAL FREEE Platform

The **Item Service** is a Spring Boot microservice in the REAL FREEE platform that allows users to list, browse, and manage items they want to give away for free.

---

## 🚀 Features

- Post and manage item listings
- Assign point values to items
- Search and retrieve items by ID
- Mark items as collected
- Integrated with Spring Cloud Gateway
- Built with JPA, Liquibase, and PostgreSQL

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.2
- Spring Data JPA
- Liquibase
- PostgreSQL
- Maven
- Docker (optional)
- Spring Cloud Gateway (integration)

---

## 🧱 Architecture

- RESTful API
- Microservice-ready
- Can register with Eureka for service discovery
- Works behind Spring Cloud Gateway with URI rewriting

---

## ⚙️ Getting Started

### 🔧 Prerequisites

- Java 17
- Maven
- PostgreSQL (or Docker)
- Optional: Redis for rate limiting

### 📁 Clone the repository

```bash
git clone https://github.com/your-org/item-service.git
cd item-service

### ⚙️ Setup Database
Create a PostgreSQL database:


CREATE DATABASE item_db;
Or use Docker:

docker run -d --name item-db -e POSTGRES_DB=item_db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres:15
### 🧪 Run the App

./mvnw spring-boot:run
App will start at:
http://localhost:8081

### 📄 API Endpoints

Method	Endpoint	Description
POST	/api/items	Create a new item
GET	/api/items	List all items
GET	/api/items/{id}	Get item by ID
PATCH	/api/items/{id}/collect	Mark item as collected
DELETE	/api/items/{id}	Delete item
🔄 Integration with Gateway
To route via gateway:

yaml
Copy
Edit
- id: item-service
  uri: http://localhost:8081
  predicates:
    - Path=/item-service/api/**
  filters:
    - RewritePath=/item-service/api/(?<remaining>.*), /api/${remaining}
Request example:


GET http://localhost:8080/item-service/api/items
### 🧪 Running Tests

./mvnw test
🛠️ Configuration
Update settings in src/main/resources/application.yml:

yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/item_db
    username: postgres
    password: postgres
Liquibase changelogs are under:
src/main/resources/db/changelog/

### 🧰 Useful Commands
Build: ./mvnw clean install

Run: ./mvnw spring-boot:run

Format: ./mvnw spotless:apply (if configured)

### 📬 Contact
Maintainer: Phu Le