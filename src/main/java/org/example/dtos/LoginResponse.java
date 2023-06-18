package org.example.dtos;

public class LoginResponse {
    private String userId;
    private String username;
    private String role;

    public LoginResponse(String userId, String username, String role) {
        this.username = username;
        this.role = role;
        this.userId = userId;
    }

    public LoginResponse() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
