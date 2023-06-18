package org.example.services.impl;

import org.example.models.Admin;
import org.example.models.Employee;
import org.example.repositories.AdminRepository;
import org.example.repositories.impl.AdminRepositoryImpl;
import org.example.services.AdminService;
import org.example.services.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;
    private EmployeeService employeeService;
    public AdminServiceImpl(AdminRepository adminRepository, EmployeeService employeeService){
        this.adminRepository = adminRepository;
        this.employeeService = employeeService;
    }

    public List<Admin> findAllAdmin(){
        return adminRepository.findAllAdmin();
    }

    public Map<String, String> findEmployeeWhereAdmin(){
        Map<String, String> employeeMap = new HashMap<>();
        List<Employee> employees = employeeService.findEmployeeWhereAdmin();

        for (Employee employee : employees) {
            employeeMap.put(employee.getName(), employee.getId());
        }

        return employeeMap;
    }

    public boolean deleteAdminAccount(String username){
        return adminRepository.deleteAdminAccount(username);
    }
    public boolean deleteAdminByEmployeeId(String employeeId){
        return adminRepository.deleteAdminAccountByEmployeeId(employeeId);
    }
}
