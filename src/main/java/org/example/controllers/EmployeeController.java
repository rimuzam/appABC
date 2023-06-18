package org.example.controllers;

import org.example.models.Employee;
import org.example.services.EmployeeService;

import java.util.List;

public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public Employee createEmployee(Employee employee){
        return employeeService.createEmployee(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeService.findAllEmployee();
    }

    public boolean updateEmployee(Employee employee){
        return employeeService.updateEmployee(employee);
    }

    public boolean deleteEmployee(String id){
        return employeeService.deleteEmployee(id);
    }

    public List<Employee> findEmployeeByName(String name){
        return employeeService.findByName(name);
    }

    public List<Employee> findEmployeeWhereAdmin(){return employeeService.findEmployeeWhereAdmin();}
}
