/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net_sports_management.dbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nk
 */
public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;

        try {
            // Load MySQL Driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database URL
            String url = "jdbc:mysql://localhost:3306/sportacademy";

            // Username & Password (XAMPP default)
            String user = "root";
            String password = "";

            // Create Connection
            con = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException | SQLException e) {
        }

        return con;
    }
    
}
