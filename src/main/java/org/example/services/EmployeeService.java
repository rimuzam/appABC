package org.example.services;

import org.example.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee request);
    boolean updateEmployee(Employee employee);
    List<Employee> findAllEmployee();
    boolean deleteEmployee(String id);
    List<Employee> findByName(String name);
    List<Employee> findEmployeeWhereAdmin();
}
