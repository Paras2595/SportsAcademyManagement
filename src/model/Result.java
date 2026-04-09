/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Result {

    private int id;
    private int tournamentId;
    private int winnerTeamId;
    private int looserTeamId;

    // ?Insert
    public Result(int tournamentId, int winnerTeamId, int looserTeamId) {
        this.tournamentId = tournamentId;
        this.winnerTeamId = winnerTeamId;
        this.looserTeamId = looserTeamId;
    }

    //  Update
    public Result(int id, int tournamentId, int winnerTeamId, int looserTeamId) {
        this.id = id;
        this.tournamentId = tournamentId;
        this.winnerTeamId = winnerTeamId;
        this.looserTeamId = looserTeamId;
    }

    public int getId() { return id; }
    public int getTournamentId() { return tournamentId; }
    public int getWinnerTeamId() { return winnerTeamId; }
    public int getLooserTeamId() { return looserTeamId; }
}