package org.example.dtos;

public class AbsentResponse {
    private String employeeId, employeeName;
    private int leave, alpha, sick, permission;

    public AbsentResponse() {
    }

    public AbsentResponse(String employeeId, String employeeName, int leave, int alpha, int sick, int permission) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.leave = leave;
        this.alpha = alpha;
        this.sick = sick;
        this.permission = permission;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getLeave() {
        return leave;
    }

    public void setLeave(int leave) {
        this.leave = leave;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int getSick() {
        return sick;
    }

    public void setSick(int sick) {
        this.sick = sick;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
