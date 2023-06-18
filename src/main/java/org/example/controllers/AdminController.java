package org.example.controllers;

import org.example.models.Admin;
import org.example.models.Employee;
import org.example.services.AdminService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminController {
    private AdminService adminService;
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    public List<Admin> findAllAdmin(){
        return adminService.findAllAdmin();
    }

    public Map<String, String> findEmployeeWhereAdmin(){
        return adminService.findEmployeeWhereAdmin();
    }

    public boolean deleteAdminAccount(String username){
        return adminService.deleteAdminAccount(username);
    }
}
