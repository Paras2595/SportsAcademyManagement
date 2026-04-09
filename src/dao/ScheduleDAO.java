
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nk
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Schedule;
import net_sports_management.dbConnection.DBConnection;

public class ScheduleDAO {

    // INSERT
    public void addSchedule(Schedule s) {

        String sql = "INSERT INTO schedules (TeamId, TournamentId, DeptId, Location, Date) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, s.getTeamId());
            ps.setInt(2, s.getTournamentId());
            ps.setInt(3, s.getDeptId());
            ps.setString(4, s.getLocation());
            ps.setString(5, s.getDate());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  UPDATE
    public void updateSchedule(Schedule s) {

        String sql = "UPDATE schedules SET TeamId=?, TournamentId=?, DeptId=?, Location=?, Date=? WHERE Id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, s.getTeamId());
            ps.setInt(2, s.getTournamentId());
            ps.setInt(3, s.getDeptId());
            ps.setString(4, s.getLocation());
            ps.setString(5, s.getDate());
            ps.setInt(6, s.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  DELETE
    public void deleteSchedule(int id) {

        String sql = "DELETE FROM schedules WHERE Id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET ALL
    public List<Object[]> getAllSchedules() {

        List<Object[]> list = new ArrayList<>();

    String sql =
        "SELECT s.Id, " +
        "t.Name AS TeamName, " +              // ✅ FIXED
        "tr.Name AS TournamentName, " +       // ✅ FIXED
        "d.Head AS DeptName, " +
        "s.Location, s.Date " +
        "FROM schedules s " +
        "JOIN teams t ON s.TeamId = t.Id " +
        "JOIN tournaments tr ON s.TournamentId = tr.Id " +
        "JOIN departments d ON s.DeptId = d.Id";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            list.add(new Object[]{
                rs.getInt("Id"),
                rs.getString("TeamName"),
                rs.getString("TournamentName"),
                rs.getString("DeptName"),
                rs.getString("Location"),
                rs.getString("Date")
            });
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
    }
}