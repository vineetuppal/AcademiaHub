# 🎓 AcademiaHub – Academic Management System

A simple **Spring Boot REST API** for managing Students, Professors, Subjects, and Admission Records.  
Designed to handle academic workflows efficiently with **Spring Boot**, **JPA**, and **Hibernate**.

---

## 📚 Features

- ✅ **Manage Students**
  - Create Student
  - Get Student by ID
  - Assign Subject to Student
  - Assign Professor to Student

- ✅ **Manage Professors**
  - Create Professor
  - Get Professor by ID
  - Assign Student to Professor

- ✅ **Manage Subjects**
  - Create Subject
  - Get Subject by ID
  - Assign Professor to Subject

- ✅ **Manage Admissions**
  - Create Admission Record
  - Get Admission Record by ID
  - Assign Student to Admission Record

---

## 🛠️ Tech Stack

- **Java 24**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Lombok**
- **MySql**
- **Maven**

---

## 📊 Database Schema Overview

### Entities & Relationships
- **`StudentEntity`**
  - 🎯 Many-to-Many → `SubjectEntity`
  - 🎯 Many-to-Many → `ProfessorEntity`
  - 🎯 One-to-One → `AdmissionRecordEntity`
  
- **`ProfessorEntity`**
  - 🎯 One-to-Many → `SubjectEntity`
  - 🎯 Many-to-Many → `StudentEntity`

- **`SubjectEntity`**
  - 🎯 Many-to-Many → `StudentEntity`
  - 🎯 Many-to-One → `ProfessorEntity`

- **`AdmissionRecordEntity`**
  - 🎯 One-to-One → `StudentEntity`

---

## 📌 API Endpoints

### 🎓 Student APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| **GET** | `/students/{id}` | Get Student by ID |
| **POST** | `/students` | Create a new Student |
| **PUT** | `/students/{studentId}/subjects/{subjectId}` | Assign Subject to Student |

### 👨‍🏫 Professor APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| **GET** | `/professors/{id}` | Get Professor by ID |
| **POST** | `/professors` | Create a new Professor |
| **PUT** | `/professors/{professorId}/students/{studentId}` | Assign Student to Professor |

### 📖 Subject APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| **GET** | `/subjects/{id}` | Get Subject by ID |
| **POST** | `/subjects` | Create a new Subject |
| **PUT** | `/subjects/{subjectId}/professors/{professorId}` | Assign Professor to Subject |

### 🏫 Admission Record APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| **GET** | `/admissions/{id}` | Get Admission Record by ID |
| **POST** | `/admissions` | Create a new Admission Record |
| **PUT** | `/admissions/{admissionId}/students/{studentId}` | Assign Student to Admission Record |

---
