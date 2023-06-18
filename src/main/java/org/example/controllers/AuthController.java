package org.example.controllers;

import org.example.database.AppDbContext;
import org.example.dtos.LoginRequest;
import org.example.dtos.LoginResponse;
import org.example.models.Admin;
import org.example.models.Personalia;
import org.example.models.User;
import org.example.repositories.AdminRepository;
import org.example.repositories.UserRepository;
import org.example.repositories.impl.AdminRepositoryImpl;
import org.example.repositories.impl.UserRepositoryImpl;
import org.example.services.AuthService;
import org.example.services.impl.AuthServiceImpl;

import java.util.List;
import java.util.Map;

public class AuthController {
    private AppDbContext context = new AppDbContext();
    private AdminRepository adminRepository = new AdminRepositoryImpl(context);
    public UserRepository userRepository = new UserRepositoryImpl(context);
    public AuthService service;
    public AuthController(AuthService service){
        this.service = service;
    }

    public String registerUser(User request){
        return service.registerUser(request);
    }

    public LoginResponse loginUser(LoginRequest request){
        return service.loginUser(request);
    }

    public String registerAdmin(Admin request){
        return service.registerAdmin(request);
    }

    public LoginResponse loginAdmin(LoginRequest request){
        return service.loginAdmin(request);
    }

    public LoginResponse loginPersonalia(Personalia request){return service.loginPersonalia(request);}
    public Map<String, String> findEmployeeWhereAdmin(){
        return service.findEmployeeWhereAdmin();
    }
    public List<Admin> findAllAdmin(){
        return service.findAllAdmin();
    }
}
