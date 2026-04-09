/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import net_sports_management.dbConnection.DBConnection;

public class PlayerDAO {

    // ADD PLAYER
    public void addPlayer(Player p) {

        String sql = "INSERT INTO players (Name, DeptId, TeamId) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setInt(2, p.getDeptId());  // ✅ store ID
            ps.setInt(3, p.getTeamId());  // ✅ store ID

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 UPDATE PLAYER
    public void updatePlayer(Player p) {

        String sql = "UPDATE players SET Name=?, DeptId=?, TeamId=? WHERE Id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setInt(2, p.getDeptId());
            ps.setInt(3, p.getTeamId());
            ps.setInt(4, p.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE PLAYER
    public void deletePlayer(int id) {

        String sql = "DELETE FROM players WHERE Id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ?GET ALL PLAYERS (SHOW NAMES )
    public List<Object[]> getAllPlayers() {

        List<Object[]> list = new ArrayList<>();

        String sql = "SELECT p.Id, p.Name, d.Head AS DeptHead, t.Name AS TeamName " +
                     "FROM players p " +
                     "JOIN departments d ON p.DeptId = d.Id " +
                     "JOIN teams t ON p.TeamId = t.Id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Object[] row = new Object[4];

                row[0] = rs.getInt("Id");
                row[1] = rs.getString("Name");
                row[2] = rs.getString("DeptHead"); // show name
                row[3] = rs.getString("TeamName"); // show Teamname

                list.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}