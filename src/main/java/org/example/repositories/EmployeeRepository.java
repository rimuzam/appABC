package org.example.repositories;

import org.example.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee createEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(String id);
    List<Employee> findAllEmployee();
    List<Employee> findAllEmployeeByName(String inputName);
    Employee findAllEmployeeById(String idReq);
    List<Employee> findEmployeeWhereAdmin();
}
