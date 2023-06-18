package org.example.services.impl;

import org.example.dtos.AbsentDetailResponse;
import org.example.dtos.AbsentResponse;
import org.example.models.Absent;
import org.example.models.Employee;
import org.example.repositories.AbsentRepository;
import org.example.services.AbsentService;
import org.example.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AbsentServiceImpl implements AbsentService {
    private AbsentRepository repository;
    private EmployeeService employeeService;
    public AbsentServiceImpl(AbsentRepository repository, EmployeeService employeeService){
        this.repository = repository;
        this.employeeService = employeeService;
    }
    public List<String> getIdNameEmployees(){
        List<Employee> employees = employeeService.findAllEmployee();
        List<String> names = new ArrayList<>();
        for (Employee employee : employees) {
            String getIdName = employee.getId()+"-"+employee.getName();
            names.add(getIdName);
        }
        return names;
    }
    public Absent createAbsent(Absent absent){
        absent.setId(UUID.randomUUID().toString());
        return repository.createAbsent(absent);
    }
    public List<AbsentResponse> findAllAbsent(){
        return repository.findAllAbsent();
    }
    public List<AbsentResponse> findAllAbsentByDate(int date, int year){
        return repository.findAbsentByDate(date, year);
    }
    public List<AbsentResponse> findAbsentByYear(int year) {
        return repository.findAbsentByYear(year);
    }
    public List<AbsentDetailResponse> findAllAbsentDetails(){
        return repository.findAllAbsentDetail();
    }
    public List<AbsentDetailResponse> findAllAbsentDetailByDate(int date, int year){
        return repository.findAbsentDetailByDate(date, year);
    }

}
