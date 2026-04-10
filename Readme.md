# 🏆 Sports Management System

A **comprehensive desktop-based Sports Management System** developed using **Java (Swing)** and **MySQL** to efficiently manage sports academy operations. This application provides a centralized and structured way to handle players, coaches, teams, tournaments, schedules, and results.

---

## 📌 Overview

The Sports Management System is designed to simplify and digitize the management of sports academies. It replaces manual processes with an intuitive graphical interface and a robust database backend, ensuring accuracy, consistency, and efficiency.

---

## 🚀 Key Features

### 🔐 Admin Authentication

- Secure login system for administrators
- Controlled access to all modules

### 🏢 Department Management

- Create, update, and delete departments
- Assign different sports categories (e.g., Cricket, Football)

### 🧑‍🏫 Coach Management

- Manage coach details including name, email, and password

### 👥 Team Management

- Create and manage teams
- Assign teams to departments and coaches

### 🏃 Player Management

- Add and manage player details
- Assign players to teams and departments

### 🏆 Tournament Management

- Create tournaments with:
  - Start Date
  - End Date
  - Number of Rounds
  - Tournament Type

### 📅 Schedule Management

- Organize match schedules with location and date

### 🥇 Result Management

- Record match results
- Track winners and losers

---

## 🛠️ Technologies Used

| Category | Technology  |
| -------- | ----------- |
| Frontend | Java Swing  |
| Backend  | Java (JDBC) |
| Database | MySQL       |
| IDE      | NetBeans    |

---

## 🗄️ Database Design

The system includes the following tables:

- `admin_login`
- `departments`
- `coach`
- `teams`
- `players`
- `tournaments`
- `schedules`
- `results`

---

## 🔗 Entity Relationships

- **Players** → Teams & Departments
- **Teams** → Coach & Department
- **Tournaments** → Department
- **Schedules** → Team, Tournament, Department
- **Results** → Tournament & Teams

---

## ⚙️ Installation & Setup

### 1. Clone Repository

```bash
git clone https://github.com/your-username/sports-management-system.git
```

### 2. Open Project

- Import the project into NetBeans IDE

### 3. Setup Database

- Open MySQL
- Create a database (e.g., `sportacademy`)
- Run the provided SQL script to create tables

### 4. Configure Database Connection

Update your database connection in:

```
DBConnection.java
```

Set your:

- Database URL
- Username
- Password

### 5. Run Application

- Run the main class from NetBeans
- Login using admin credentials

---

## 🎯 Project Objectives

- Digitize sports academy management
- Maintain structured and relational data
- Provide a user-friendly GUI
- Reduce manual errors and improve efficiency

---

## 🔮 Future Enhancements

- 🌐 Web-based version (Spring Boot / React)
- 📱 Mobile application
- 📊 Player performance analytics
- 🔐 Role-based authentication (Admin / Coach)
- ☁️ Cloud database integration

---

## 👨‍💻 Author

**Paras**
Developer – Sports Management System

---

## 📄 License

This project is intended for educational purposes only...

---

## ⭐ Support

If you find this project useful, consider giving it a ⭐ on GitHub!
