# Employee Managemen tBackend

This is the **backend** of the Employee Management System, built using **Spring Boot**.  
It provides a RESTful API to perform **CRUD operations** (Create, Read, Update, Delete) on employee records using a **MySQL** database.

👉 **Frontend Repository:** [EmployeeManagementFrontend (Angular)](https://github.com/Rash023/Angular-Sandbox/tree/main/employee-management-frontend)

## Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- RESTful APIs

## Features

- `POST /api/employees/add` – Add a new employee
- `GET /api/employees` – Get all employees
- `GET /api/employees/{id}` – Get employee by ID
- `PUT /api/employees/update/{id}` – Update employee by ID
- `DELETE /api/employees/delete/{id}` – Delete employee by ID

### Prerequisites

- Java 17+
- Maven
- MySQL running locally

### Setup

1. **Clone the repository**

```bash
git clone https://github.com/your-username/EmployeeManagementBackend.git
cd EmployeeManagementBackend

```

2. **Configure the database**

   Edit src/main/resources/application.properties

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/employeedb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


```

3. **Run the application**

```bash
./mvnw spring-boot:run
```
