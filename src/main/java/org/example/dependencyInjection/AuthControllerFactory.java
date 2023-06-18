package org.example.dependencyInjection;

import org.example.controllers.AuthController;
import org.example.database.AppDbContext;
import org.example.repositories.*;
import org.example.repositories.impl.*;
import org.example.services.AuthService;
import org.example.services.EmployeeService;
import org.example.services.impl.AuthServiceImpl;
import org.example.services.impl.EmployeeServiceImpl;

public class AuthControllerFactory {
    private AppDbContext context = new AppDbContext();
    private AdminRepository adminRepository = new AdminRepositoryImpl(context);
    private UserRepository userRepository = new UserRepositoryImpl(context);
    private PersonaliaRepository personaliaRepository = new PersonaliaRepositoryImpl(context);
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl(context);
    private AbsentRepository absentRepository = new AbsentRepositoryImpl(context);
    private EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository, adminRepository, absentRepository);
    private AuthService authService = new AuthServiceImpl(userRepository, adminRepository, personaliaRepository, employeeService);

    public AuthController create() {
        return new AuthController(authService);
    }
}
