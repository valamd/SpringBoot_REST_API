# 🎂 Online Cake Shop REST API 🍰

Welcome to the **Online Cake Shop REST API** built with **Spring Boot**! This project serves as the backend for managing cakes, customers, orders, and admin operations in an online cake store. 🎉

---

## 🚀 Features

- 👩‍🍳 Admin Management
- 🧁 Cake Catalog (Add, Update, Delete, View)
- 👤 Customer Registration & Management
- 🛒 Order Placement and Tracking
- 🔐 Secure Controller Structure
- 📦 CRUD operations via RESTful APIs

---

## 🛠️ Tech Stack

| Layer         | Technology            |
|---------------|------------------------|
| Backend       | Spring Boot 🌱         |
| Build Tool    | Maven 🧰               |
| Language      | Java ☕                |
| Database      | (Not explicitly listed — assumed JPA for DB) 🗃️ |
| API Style     | RESTful 🛰️             |

---

## 🧪 API Endpoints (Examples)

> Full endpoints exist in `/controller` files.

### 🧁 Cake Controller
GET /cakes → Get all cakes
POST /cakes → Add a new cake
PUT /cakes/{id} → Update cake
DELETE /cakes/{id} → Delete cake


### 👤 Customer Controller
GET /customers → View all customers
POST /customers/register → Register a new customer


### 🛒 Order Controller
GET /orders → View orders
POST /orders/place → Place a new order


### 👩‍💼 Admin Controller
POST /admin/login → Admin login
GET /admin/dashboard → Admindashboard



---

## ▶️ How to Run

1. 📦 **Clone the Repository**
   ```bash
   git clone https://github.com/your-repo/CakeShopAPI.git
   cd CakeShopAPI/OrderSystemrepo

2. 🧰 Build the Project
  ./mvnw clean install

3. 🚀 Run the Application
  ./mvnw spring-boot:run
  
4. 🔗 Access API
  http://localhost:8080/


📁 **Project Structure**
OrderSystemrepo/<br>
├── controller/         # REST Controllers for Cake, Customer, Admin, Order<br>
├── entity/             # Data Models (Cake, Customer, Order, Admin)<br>
├── repository/         # JPA Repositories<br>
├── resources/          # Configuration files (application.properties)<br>
├── OrderSystemApplication.java<br>
└── pom.xml             # Maven configuration<br>

**Screenshot**:
Postman:
![image](https://github.com/user-attachments/assets/4c7ae52d-0f47-4f7d-8041-f554a4446b9d)

**
