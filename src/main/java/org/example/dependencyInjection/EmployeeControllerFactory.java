package org.example.dependencyInjection;

import org.example.controllers.EmployeeController;
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

public class EmployeeControllerFactory {
    private AppDbContext context = new AppDbContext();
    private EmployeeRepository repository = new EmployeeRepositoryImpl(context);
    private AdminRepository adminRepository = new AdminRepositoryImpl(context);
    private AbsentRepository absentRepository = new AbsentRepositoryImpl(context);
    private EmployeeService employeeService = new EmployeeServiceImpl(repository, adminRepository, absentRepository);
    public EmployeeController controller (){
        return new EmployeeController(employeeService);
    }
}
