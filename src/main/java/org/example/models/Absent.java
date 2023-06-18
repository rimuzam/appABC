package org.example.models;

import java.util.Date;

public class Absent {
    private String id, employeeId, information;
    private String date;

    public Absent() {
    }

    public Absent(String id, String employeeId, String information, String date) {
        this.id = id;
        this.employeeId = employeeId;
        this.information = information;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
