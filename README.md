# Parking-Lot-System
🚗 Parking Lot Management System
📋 Project Overview

The Parking Lot Management System is a full-stack backend application built using Spring Boot, Spring Data JPA, and MySQL. It automates and manages all the operations of a parking facility — from vehicle entry and exit to real-time slot tracking and billing.

This system implements role-based authentication using Spring Security, where Admins can manage parking slots, users, and reports, while Users can check available slots, park vehicles, and generate parking receipts.

Designed with scalability and maintainability in mind, this project follows a clean layered architecture with proper entity relationships, exception handling, and service abstraction.

💡 Core Features

🅿️ Dynamic Slot Allocation: Assigns parking slots based on availability and vehicle type.

🔐 Role-Based Authentication:

Admin: Manage slots, view reports, update tariffs.

User: Park vehicles, view bills, check slot status.

🕒 Entry & Exit Tracking: Logs vehicle entry/exit time and computes parking duration.

💰 Automated Billing System: Calculates charges dynamically based on duration and vehicle type.

🧾 Transaction History: Maintains records of all parking activities.

⚙️ RESTful APIs: Well-structured endpoints for integration with frontend or mobile apps.

🧠 Tech Stack

Backend: Spring Boot 3.x

Security: Spring Security + JWT Authentication

Database: MySQL

ORM: Spring Data JPA / Hibernate

Build Tool: Maven

API Testing: Postman

IDE: IntelliJ IDEA / VS Code

🧩 System Architecture

Layered Architecture:

Controller → Service → Repository → Entity


Key Entities:

User (Admin / Customer)

Vehicle

ParkingSlot

ParkingTicket

Payment

Relationships:

One-to-Many: User → Vehicles

One-to-One: Vehicle → ParkingTicket

Many-to-One: Slot → Vehicle

🚀 Getting Started
1️⃣ Clone the repository
git clone https://github.com/yourusername/parking-lot-management-system.git

2️⃣ Configure MySQL

Create a new database:

CREATE DATABASE parking_lot_db;


Update your application.properties file:

spring.datasource.url=jdbc:mysql://localhost:3306/parking_lot_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

3️⃣ Run the application
mvn spring-boot:run

4️⃣ Test the APIs

Import the included Postman collection or use:

http://localhost:8080/api/v1/...

🔐 Roles and Access
Role	Permissions
Admin	Add/Delete slots, View reports, Manage tariffs
User	View slots, Park/Unpark vehicles, Generate bills
📈 Future Enhancements

Integration with React / Angular frontend

Online booking system for reserved slots

QR-based ticket scanning

IoT-based real-time slot monitoring

Payment gateway integration (Razorpay / Stripe)

🧑‍💻 Author

Rohit Kumar Dubey
📬 LinkedIn: https://www.linkedin.com/in/rohit-dubey-bb4bba18a/
 | GitHub: https://github.com/Rohitdubey-tech
