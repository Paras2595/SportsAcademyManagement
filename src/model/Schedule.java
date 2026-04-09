/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nk
 */
package model;

public class Schedule {

    private int id;
    private int teamId;
    private int tournamentId;
    private int deptId;
    private String location;
    private String date;

    // INSERT constructor
    public Schedule(int teamId, int tournamentId, int deptId, String location, String date) {
        this.teamId = teamId;
        this.tournamentId = tournamentId;
        this.deptId = deptId;
        this.location = location;
        this.date = date;
    }

    // UPDATE constructor
    public Schedule(int id, int teamId, int tournamentId, int deptId, String location, String date) {
        this.id = id;
        this.teamId = teamId;
        this.tournamentId = tournamentId;
        this.deptId = deptId;
        this.location = location;
        this.date = date;
    }

    //  GETTERS
    public int getId() { return id; }
    public int getTeamId() { return teamId; }
    public int getTournamentId() { return tournamentId; }
    public int getDeptId() { return deptId; }
    public String getLocation() { return location; }
    public String getDate() { return date; }
}