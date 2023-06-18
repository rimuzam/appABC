package org.example.dependencyInjection;

import org.example.controllers.AbsentController;
import org.example.database.AppDbContext;
import org.example.repositories.AbsentRepository;
import org.example.repositories.AdminRepository;
import org.example.repositories.EmployeeRepository;
import org.example.repositories.impl.AbsentRepositoryImpl;
import org.example.repositories.impl.AdminRepositoryImpl;
import org.example.repositories.impl.EmployeeRepositoryImpl;
import org.example.services.AbsentService;
import org.example.services.AdminService;
import org.example.services.EmployeeService;
import org.example.services.impl.AbsentServiceImpl;
import org.example.services.impl.EmployeeServiceImpl;

public class AbsentControllerFactory {
    private AppDbContext context = new AppDbContext();
    private AbsentRepository repository = new AbsentRepositoryImpl(context);
    private AdminRepository adminRepository = new AdminRepositoryImpl(context);
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(context);
    private EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository, adminRepository, repository );
    private AbsentService service = new AbsentServiceImpl(repository, employeeService);
    public AbsentController controller(){
        return new AbsentController(service);
    }
}
