# Book Manager Project

## Project Description

Book Manager is a Java console application designed to help users manage a collection of books. The app uses Hibernate ORM for database operations and Maven for dependency management. Data is stored persistently in a MySQL 8.0 database.

## Key Features

* Add new books with details: name, category, and rating
* View all saved books
* Delete books by their ID
* Simple and interactive console-based user interface

## Technologies Used

* **Java 17+** — Core programming language
* **Hibernate ORM** — Object Relational Mapping to interact with MySQL
* **Maven** — Project build and dependency management
* **MySQL 8.0** — Relational database for data storage
* **JPA Annotations** — For mapping Java classes to database tables

## How It Works

* The user interacts with the console menu to perform CRUD operations.
* Hibernate manages the session and transactions with the database.
* The `Book` entity class maps to the `book` table in MySQL.
* The `BookDao` class handles saving, deleting, and fetching book records.

## Database Schema

```sql
CREATE TABLE book (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  category VARCHAR(255),
  rating FLOAT
);
```
