package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Tournament;
import net_sports_management.dbConnection.DBConnection;

public class TournamentDAO {

    //  ADD TOURNAMENT
    public void addTournament(Tournament t) {

        String sql = "INSERT INTO tournaments " +
                     "(Name, StartDate, EndDate, NumberOfRound, TournamentType, DeptId) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, t.getTournamentName());
            ps.setString(2, t.getStartDate());
            ps.setString(3, t.getEndDate());
            ps.setInt(4, t.getNumberOfRound());
            ps.setString(5, t.getTournamentType());
            ps.setInt(6, t.getDeptId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  UPDATE TOURNAMENT
    public void updateTournament(Tournament t) {

        String sql = "UPDATE tournaments SET " +
                     "Name=?, StartDate=?, EndDate=?, NumberOfRound=?, TournamentType=?, DeptId=? " +
                     "WHERE Id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, t.getTournamentName());
            ps.setString(2, t.getStartDate());
            ps.setString(3, t.getEndDate());
            ps.setInt(4, t.getNumberOfRound());
            ps.setString(5, t.getTournamentType());
            ps.setInt(6, t.getDeptId());
            ps.setInt(7, t.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  DELETE TOURNAMENT
    public void deleteTournament(int id) {

        String sql = "DELETE FROM tournaments WHERE Id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  GET ALL TOURNAMENTS (WITH DEPARTMENT HEAD)
    public List<Object[]> getAllTournaments() {

        List<Object[]> list = new ArrayList<>();

        String sql = "SELECT t.Id, t.Name, t.StartDate, t.EndDate, " +
                     "t.NumberOfRound, t.TournamentType, d.Head AS DeptHead " +
                     "FROM tournaments t " +
                     "JOIN departments d ON t.DeptId = d.Id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Object[] row = new Object[7];

                row[0] = rs.getInt("Id");
                row[1] = rs.getString("Name");
                row[2] = rs.getString("StartDate");
                row[3] = rs.getString("EndDate");
                row[4] = rs.getInt("NumberOfRound");
                row[5] = rs.getString("TournamentType");
                row[6] = rs.getString("DeptHead"); // shown in GUI

                list.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    // vimp GET ALL TOURNAMENT OBJECTS (FOR COMBOBOX)
public List<Tournament> getAllTournamentObjects() {

    List<Tournament> list = new ArrayList<>();

    String sql = "SELECT * FROM tournaments";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            Tournament t = new Tournament(
                rs.getInt("Id"),
                rs.getString("Name"),
                rs.getString("StartDate"),
                rs.getString("EndDate"),
                rs.getInt("NumberOfRound"),
                rs.getString("TournamentType"),
                rs.getInt("DeptId")
            );

            list.add(t);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return list;
}
}