package org.example.models;

public class Admin {
    private String id, username, password, employee_id;

    public Admin() {
    }

    public Admin(String id, String username, String password, String employee_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.employee_id = employee_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
