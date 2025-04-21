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
```
### ⚙️ Setup Database

Create a PostgreSQL database:

```sql
CREATE DATABASE item_db;
```
Or use Docker:
```bash
docker run -d --name item-db \
  -e POSTGRES_DB=item_db \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 postgres:15

```
### 🧪 Run the App
```bash
./mvnw spring-boot:run
```
The app will be available at:
http://localhost:8081

### 📄 API Endpoints

Method	Endpoint	Description
POST	/api/items	Create a new item
GET	/api/items	List all items
GET	/api/items/{id}	Get item by ID
PATCH	/api/items/{id}/collect	Mark item as collected
DELETE	/api/items/{id}	Delete item

### Contact
Phu Le