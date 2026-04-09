/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Player {

    private int id;
    private String name;
    private int deptId;
    private int teamId;

    // Default
    public Player() {}

    // INSERT
    public Player(String name, int deptId, int teamId) {
        this.name = name;
        this.deptId = deptId;
        this.teamId = teamId;
    }

    // UPDATE
    public Player(int id, String name, int deptId, int teamId) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
        this.teamId = teamId;
    }

    // GETTERS & SETTERS

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be empty");
        }
        this.name = name;
    }

    public int getDeptId() { return deptId; }
    public void setDeptId(int deptId) { this.deptId = deptId; }

    public int getTeamId() { return teamId; }
    public void setTeamId(int teamId) { this.teamId = teamId; }
}