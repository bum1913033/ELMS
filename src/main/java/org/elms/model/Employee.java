package org.elms.model;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String faculty;
    private int absence;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String faculty, int absence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.absence = absence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }
}
