package model;

public class Team {

    private int id;
    private String teamName;
    private int deptId;
    private int coachId;   // ✅ FIXED (int instead of String)

    // Default Constructor
    public Team() {
    }

    // INSERT

    /**
     *
     * @param teamName
     * @param deptId
     * @param coachId
     */
    public Team(String teamName, int deptId, int coachId) {
        this.teamName = teamName;
        this.deptId = deptId;
        this.coachId = coachId;
    }

    // UPDATE
    public Team(int id, String teamName, int deptId, int coachId) {
        this.id = id;
        this.teamName = teamName;
        this.deptId = deptId;
        this.coachId = coachId;
    }

    // GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setName(String teamName) {
        if (teamName == null || teamName.trim().isEmpty()) {
            throw new IllegalArgumentException("Team teamName cannot be empty");
        }
        this.teamName = teamName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    // Accessing METHOD  from gui
    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }
    
    @Override
public String toString() {
    return teamName;   // shows teamName in ComboBox
}

    }