EasyTable Backend - RESTful API for Reservation Management
🚀 Project Overview
EasyTable Backend is a robust, scalable RESTful API designed for a comprehensive restaurant reservation management system. This project serves as the core engine for automating reservation workflows, managing table availability in real-time, and optimizing the overall customer experience.

Developed with a focus on Clean Architecture and SOLID principles, this backend is built to be resilient, maintainable, and ready for high-availability Cloud environments.
+2

🛠️ Technical Stack

Language: Java 17+.


Framework: Spring Boot 3.x (Spring Web, Data JPA, Security).

Security: Spring Security with JWT (JSON Web Tokens) for stateless authentication.


Database: PostgreSQL for reliable relational data persistence.

Build Tool: Maven.

Documentation: Swagger / OpenAPI 3.0.


Containerization: Docker & Docker Compose (Cloud-Native ready).

🏗️ Architecture & Patterns
To ensure separation of concerns and ease of testing, the project follows a layered architecture:

Controller Layer: Exposes REST endpoints following the Richardson Maturity Model.

Service Layer: Contains business logic and complex validation rules.

Persistence Layer: Utilizes the Repository pattern for efficient database abstraction.

DTO Pattern: Implements Data Transfer Objects to decouple internal domain models from the public API.

✨ Core Features
✅ Reservation Lifecycle: End-to-end management (Create, Cancel, Status updates).

✅ Dynamic Availability: Intelligent business logic to prevent overbooking based on capacity and schedules.

✅ Role-Based Access Control (RBAC): Secured endpoints for Admins (Restaurants) and Users (Customers).

✅ Cloud-Ready Infrastructure: Optimized configuration for deployment on Kubernetes (EKS, OpenShift, or Scaleway).
+4

🔧 Installation & Setup
Prerequisites
JDK 17 or higher.

Maven 3.8+.

Docker & Docker Compose (Optional for local DB).

Local Execution
Clone the repository:

Bash
git clone https://github.com/omarparedes23/easytableback.git
cd easytableback
Configure environment variables in src/main/resources/application.properties or via a .env file.

Build and run the application:

Bash
mvn spring-boot:run
Running with Docker
This project is container-ready for seamless deployment:

Bash
docker-compose up --build
📊 API Documentation
Once the application is running, you can access the interactive Swagger UI at: http://localhost:8080/swagger-ui.html

👨‍💻 Author

Omar Paredes - DevOps & Cloud Engineer 


LinkedIn :  https://www.linkedin.com/in/omarparedes23


GitHub
