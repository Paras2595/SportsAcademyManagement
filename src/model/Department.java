/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nk
 */
public class Department {
     private int id;
    private String name;
    private String head;

    public Department() {}

    public Department(String name, String head) {
        this.name = name;
        this.head = head;
         }

    public Department(int id, String name, String head) {
        this.id = id;
        this.name = name;
        this.head = head;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getHead() { return head; }
    public void setHead(String head) { this.head = head; }
    @Override
    public String toString() {
        return head;} // this shows in ComboBox
    
}
