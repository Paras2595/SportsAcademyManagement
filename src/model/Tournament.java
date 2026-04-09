/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Tournament {

    private int id;
    private String tournamentName;
    private String startDate;
    private String endDate;
    private int numberOfRound;
    private String tournamentType;
    private int deptId; // FK

    // INSERT
    public Tournament(String tournamentName, String startDate, String endDate,
                      int numberOfRound, String tournamentType, int deptId) {
        this.tournamentName =tournamentName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfRound = numberOfRound;
        this.tournamentType = tournamentType;
        this.deptId = deptId;
    }

    // UPDATE
    public Tournament(int id, String tournamentName, String startDate, String endDate,
                      int numberOfRound, String tournamentType, int deptId) {
        this.id = id;
        this.tournamentName =tournamentName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfRound = numberOfRound;
        this.tournamentType = tournamentType;
        this.deptId = deptId;
    }

    public Tournament() {}

    // GETTERS
    public int getId() { return id; }
    public String getTournamentName() { return tournamentName; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public int getNumberOfRound() { return numberOfRound; }
    public String getTournamentType() { return tournamentType; }
    public int getDeptId() { return deptId; }

    // SETTERS
    public void setId(int id) { this.id = id; }
    
    @Override
public String toString() {
    return tournamentName;
}
}