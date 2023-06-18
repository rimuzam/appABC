package org.example.dependencyInjection;

import org.example.controllers.AdminController;
import org.example.database.AppDbContext;
import org.example.repositories.AbsentRepository;
import org.example.repositories.AdminRepository;
import org.example.repositories.EmployeeRepository;
import org.example.repositories.impl.AbsentRepositoryImpl;
import org.example.repositories.impl.AdminRepositoryImpl;
import org.example.repositories.impl.EmployeeRepositoryImpl;
import org.example.services.AdminService;
import org.example.services.EmployeeService;
import org.example.services.impl.AdminServiceImpl;
import org.example.services.impl.EmployeeServiceImpl;

public class AdminControllerFactory {
    private AppDbContext context = new AppDbContext();
    private AdminRepository adminRepository = new AdminRepositoryImpl(context);
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(context);
    private AbsentRepository absentRepository = new AbsentRepositoryImpl(context);
    private EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository, adminRepository, absentRepository);
    private AdminService adminService = new AdminServiceImpl(adminRepository, employeeService);
    public AdminController controller(){
        return new AdminController(adminService);
    }
}
