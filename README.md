# Heart Rate Management System

## Overview
The Heart Rate Management System is a simple Spring Boot application designed to manage patient records and their heart rate data. It provides APIs to register users, manage patients, and record/retrieve heart rate details.


---

## Features

### 1. Users
- Manage user information such as user profiles, including basic details like email, name, and contact information.
- Implement user registration and login using email and password. Email and password validation should be handled directly, with no authentication or authorization protocols.

### 2. Patients
- Manage patient information including patient profiles, medical history, and contact details.
- API endpoint to **add a new patient** to the system.
- API endpoint to **retrieve patient details** (using patient ID or other identifiers).

### 3. Heart Rate Details
- Record and manage heart rate data for patients.
- API endpoint to **record** heart rate readings for a specific patient.
- API endpoint to **retrieve** heart rate data for a specific patient.

## API Endpoints
Swagger used for API Documentation:
![Screenshot (658)](https://github.com/user-attachments/assets/f45cb3cb-708f-45b9-826d-d1318724858c)
![Screenshot (657)](https://github.com/user-attachments/assets/97d1d37c-9ae9-44e7-954e-d2a59de0e3da)
![Screenshot (656)](https://github.com/user-attachments/assets/403e81de-f844-4196-93ab-b4510d92899c)
![Screenshot (655)](https://github.com/user-attachments/assets/c57b1b5f-36ae-45ac-9546-654334d823dd)
![Screenshot (654)](https://github.com/user-attachments/assets/3f5f13af-fd21-484b-aafe-07cd8d677a77)
![Screenshot (653)](https://github.com/user-attachments/assets/0f6b0e44-06f8-4e44-99e0-3ec49a4b422d)
![Screenshot (652)](https://github.com/user-attachments/assets/21295ed1-ef15-4caf-9208-d116c185bd21)
![Screenshot (651)](https://github.com/user-attachments/assets/0d73e76b-909d-4d9a-8c45-aa34ec7b03bd)
![Screenshot (650)](https://github.com/user-attachments/assets/dd894e89-9bb2-4b5b-99ff-7464589f66bb)
![Screenshot (649)](https://github.com/user-attachments/assets/17a68bc8-2dc1-4d2b-b8d9-097ecf19e782)
![Screenshot (648)](https://github.com/user-attachments/assets/ecca91c7-5a46-4172-8253-852b5c932980)
![Screenshot (647)](https://github.com/user-attachments/assets/e827b486-1768-4415-8e9e-d164493905df)
![Screenshot (646)](https://github.com/user-attachments/assets/96e02a15-6409-4e92-ba4a-7413e68851cc)

## API Testing 
- postman used for API Testing below is video for API Testing
https://github.com/user-attachments/assets/ee9bd9a3-2f97-4269-8757-fa54e44e826d

## Database Structure
- **Users Table**: Stores user details.
- **Patients Table**: Stores patient details including medical history.
- **HeartRate Table**: Logs heart rate data for each patient.

# Spring Boot Application Configuration
spring.application.name=patientheart
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update





# Used
- Java Development Kit (JDK) 8 or higher
- Maven  (for building the project)
- A database (H2 in-memory database is used by default)
