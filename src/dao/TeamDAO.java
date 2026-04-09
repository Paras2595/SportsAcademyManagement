package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Team;
import net_sports_management.dbConnection.DBConnection;

public class TeamDAO {

    //  ADD TEAM
    public void addTeam(Team t) {

        String sql = "INSERT INTO teams (Name, DeptId, CoachId) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, t .getTeamName());
            ps.setInt(2, t.getDeptId());
            ps.setInt(3, t.getCoachId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE TEAM
    public void updateTeam(Team t) {

        String sql = "UPDATE teams SET Name=?, DeptId=?, CoachId=? WHERE Id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, t .getTeamName());
            ps.setInt(2, t.getDeptId());
            ps.setInt(3, t.getCoachId());
            ps.setInt(4, t.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ?DELETE TEAM
    public void deleteTeam(int id) {

        String sql = "DELETE FROM teams WHERE Id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 GET ALL TEAMS (WITH OBJECT[])
    public List<Object[]> getAllTeams() {

        List<Object[]> list = new ArrayList<>();

    String sql = "SELECT t.Id, t.Name, d.Head AS Department, c.Name AS Coach " +
                 "FROM teams t " +
                 "JOIN departments d ON t.DeptId = d.Id " +
                 "JOIN coach c ON t.CoachId = c.CoachId";   // ✅ VERY IMPORTANT

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            list.add(new Object[]{
                rs.getInt("Id"),
                rs.getString("Name"),
                rs.getString("Department"),
                rs.getString("Coach")   // ✅ THIS FIXES YOUR ISSUE
            });
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;}
    
    // vimp GET ALL TEAM OBJECTS (FOR COMBOBOX)
public List<Team> getAllTeamObjects() {

    List<Team> list = new ArrayList<>();

    String sql = "SELECT * FROM teams";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            Team t = new Team(
                rs.getInt("Id"),
                rs.getString("Name"),
                rs.getInt("DeptId"),
                rs.getInt("CoachId")
            );

            list.add(t);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
    
}