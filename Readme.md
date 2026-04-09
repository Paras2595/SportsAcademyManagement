📌 Sports Management System

The Sports Management System is a desktop-based application developed using Java (Swing) and MySQL to manage and organize sports academy activities efficiently. This project provides a centralized system for handling players, coaches, teams, tournaments, schedules, and match results.

🚀 Features
🔐 Admin Login System
Secure login for system access
🏢 Department Management
Add, update, delete departments
Assign sports categories (Cricket, Football, etc.)
🧑‍🏫 Coach Management
Manage coach details (name, email, password)
👥 Team Management
Create teams linked with departments and coaches
🏃 Player Management
Add players and assign them to teams and departments
🏆 Tournament Management
Manage tournament details like:
Start Date
End Date
Number of Rounds
Tournament Type
📅 Schedule Management
Schedule matches with location and date
🥇 Result Management
Record winners and losers of tournaments
🛠️ Technologies Used
Frontend: Java Swing (GUI)
Backend: Java (JDBC)
Database: MySQL
IDE: NetBeans
🗄️ Database Structure

The system uses the following tables:

admin_login
departments
coach
teams
players
tournaments
schedules
results

All tables are connected using foreign key relationships to maintain data integrity.

🔗 Key Relationships
Players → Teams & Departments
Teams → Coach & Department
Tournaments → Department
Schedules → Team, Tournament, Department
Results → Tournament & Teams
🎯 Objective

The main objective of this project is to:

Simplify sports academy management
Reduce manual work
Provide an organized and user-friendly system
Maintain accurate and structured data

👨‍💻 Author
Paras
Developed as an academic project
