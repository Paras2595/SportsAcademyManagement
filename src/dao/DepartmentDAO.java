/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.*;
import model.Department;
import net_sports_management.dbConnection.DBConnection;

/**
 *
 * @author nk
 */
public class DepartmentDAO {
    // ADD
    public void addDepartment(Department d) {
        try {
            Connection con = DBConnection.getConnection();
            String q = "INSERT INTO departments (Name, Head) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, d.getName());
            ps.setString(2, d.getHead());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    
    // VIEW
    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String q = "SELECT Id, Name, Head FROM departments";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Department d = new Department();

                d.setId(rs.getInt("Id"));
                d.setName(rs.getString("Name"));
                d.setHead(rs.getString("Head"));   // ⭐ IMPORTANT

list.add(d);
            }

        } catch (SQLException e) {
        }
        return list;
    }
    
    // UPDATE
    public void updateDepartment(Department d) {
        try {
            Connection con = DBConnection.getConnection();
            String q = "UPDATE departments SET Name=?, Head=? WHERE Id=?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, d.getName());
            ps.setString(2, d.getHead());
            ps.setInt(3, d.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
     // DELETE
    public void deleteDepartment(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String q = "DELETE FROM departments WHERE Id=?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
}
