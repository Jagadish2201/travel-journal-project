# ✈️ Travel Journal Project

A Java-based Travel Journal Management System developed using **Spring Framework, Hibernate ORM, and MySQL**. The project demonstrates a layered DAO architecture, Spring dependency management, Hibernate-based persistence, and database operations using MySQL.

---

## 📌 Project Overview

The **Travel Journal Project** is designed to manage and store travel journal information in a MySQL database.

The project uses **Spring Framework** for dependency management and **Hibernate ORM** for object-relational mapping and database persistence.

A **DAO (Data Access Object) architecture** is used to separate database-related operations from the application logic, making the project easier to understand, maintain, and extend.

---

## 🎯 Objectives

- Understand Hibernate ORM and database persistence.
- Implement CRUD-related database operations using Hibernate.
- Understand the DAO design pattern.
- Implement Spring IoC and Dependency Injection.
- Configure Spring and Hibernate using XML.
- Connect a Java application with MySQL.
- Understand layered application architecture.
- Manage project dependencies using Maven.

---

## 🚀 Features

- Travel journal data management
- Hibernate-based database operations
- MySQL database integration
- DAO and DAO Implementation architecture
- Spring dependency management
- XML-based Spring configuration
- XML-based Hibernate configuration
- Automatic database schema update using Hibernate
- Maven dependency management
- Separation of application and database logic

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| **Java** | Application development |
| **Spring Core** | IoC and Dependency Injection |
| **Spring Framework** | Bean and dependency management |
| **Hibernate ORM** | Object-Relational Mapping and persistence |
| **MySQL** | Database management |
| **JDBC** | Database connectivity |
| **Maven** | Dependency and build management |
| **XML** | Spring and Hibernate configuration |
| **Lombok** | Reducing boilerplate code |

---

## 🏗️ Project Architecture

The project follows a layered DAO architecture:

```text
                Application
                     ↓
        TravelJournalManagement
                     ↓
             TravelJournalDao
                     ↓
          TravelJournalDaoImpl
                     ↓
            ConnectionEstablish
                     ↓
           Hibernate SessionFactory
                     ↓
              Hibernate Session
                     ↓
                 MySQL
