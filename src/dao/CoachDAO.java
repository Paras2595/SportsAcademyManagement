package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Coach;
import net_sports_management.dbConnection.DBConnection;

public class CoachDAO {

   
    public void addCoach(Coach c) {

        String sql = "INSERT INTO coach (Name, Email, Password) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getPassword());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public void updateCoach(Coach c) {

        String sql = "UPDATE coach SET Name=?, Email=?, Password=? WHERE CoachId=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getPassword());
            ps.setInt(4, c.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public void deleteCoach(int CoachId) {

        String sql = "DELETE FROM coach WHERE CoachId=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, CoachId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   // using to load on cmb
    public List<Coach> getAllCoaches() {

        List<Coach> list = new ArrayList<>();

        String sql = "SELECT * FROM coach";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Coach c = new Coach(
                        rs.getInt("CoachId"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Password")
                );

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // GET DATA FOR TABLE
    public List<Object[]> getCoachTable() {

        List<Object[]> list = new ArrayList<>();

        String sql = "SELECT * FROM coach";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                list.add(new Object[]{
                        rs.getInt("CoachId"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Password")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}