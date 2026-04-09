package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Result;
import net_sports_management.dbConnection.DBConnection;

public class ResultDAO {

    // INSERT
    public void addResult(Result r) {

        String sql = "INSERT INTO results (TournamentId, WinnerTeamId, LooserTeamId) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, r.getTournamentId());
            ps.setInt(2, r.getWinnerTeamId());
            ps.setInt(3, r.getLooserTeamId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ? UPDATE
    public void updateResult(Result r) {

        String sql = "UPDATE results SET TournamentId=?, WinnerTeamId=?, LooserTeamId=? WHERE Id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, r.getTournamentId());
            ps.setInt(2, r.getWinnerTeamId());
            ps.setInt(3, r.getLooserTeamId());
            ps.setInt(4, r.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ?DELETE
    public void deleteResult(int id) {

        String sql = "DELETE FROM results WHERE Id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  GET ALL (FOR TABLe)
    public List<Object[]> getAllResults() {

        List<Object[]> list = new ArrayList<>();

        String sql =
            "SELECT r.Id, t.Name AS TournamentName, " +
            "w.Name AS WinnerTeam, l.Name AS LooserTeam " +
            "FROM results r " +
            "JOIN tournaments t ON r.TournamentId = t.Id " +
            "JOIN teams w ON r.WinnerTeamId = w.Id " +
            "JOIN teams l ON r.LooserTeamId = l.Id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                list.add(new Object[]{
                    rs.getInt("Id"),
                    rs.getString("TournamentName"),
                    rs.getString("WinnerTeam"),
                    rs.getString("LooserTeam")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}