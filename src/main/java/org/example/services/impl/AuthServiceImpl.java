package org.example.services.impl;

import org.example.dtos.LoginRequest;
import org.example.dtos.LoginResponse;
import org.example.exceptions.UnauthorizedException;
import org.example.models.*;
import org.example.repositories.AdminRepository;
import org.example.repositories.PersonaliaRepository;
import org.example.repositories.UserRepository;
import org.example.services.AuthService;
import org.example.services.EmployeeService;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.util.*;

public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    AdminRepository adminRepository;
    PersonaliaRepository personaliaRepository;
    EmployeeService employeeService;

    public AuthServiceImpl(UserRepository userRepository, AdminRepository adminRepository, PersonaliaRepository personaliaRepository, EmployeeService employeeService) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.personaliaRepository = personaliaRepository;
        this.employeeService = employeeService;
    }

    private User loadEmailUser(String emailInput) {
        User user = userRepository.findUserByEmail(emailInput);

        if (user == null) throw new UnauthorizedException("Pengguna belum terdaftar");

        return user;
    }
    private User loadRegisterEmailUser(String email){
        User user = userRepository.findUserByEmail(email);

        if (user != null)  throw new UnauthorizedException("Registrasi gagal, email sudah terdaftar !");

        return user;
    }

    private Admin loadUsernameAdmin(String employeeId) {
        Admin admin = adminRepository.findAdminByEmployeeId(employeeId);

        if (admin == null) throw new UnauthorizedException("Username atau password salah. Hubungi personalia jika ada masalah login");

        return admin;
    }

    private Admin loadRegisterUsernameAdmin(String usernameInput){
        Admin admin = adminRepository.findAdminByEmployeeId(usernameInput);

        if (admin != null) throw new UnauthorizedException("Registrasi gagal, admin sudah terdaftar !");

        return admin;
    }

    public String registerAdmin(Admin request){
        loadRegisterUsernameAdmin(request.getUsername());
        request.setId(UUID.randomUUID().toString());
        Admin admin = new Admin(request.getId(), request.getUsername(), request.getPassword(), request.getEmployee_id());
        Admin saveAdmin = adminRepository.createAdmin(admin);

        return saveAdmin.getUsername();
    }

    public LoginResponse loginAdmin(LoginRequest request){
        Admin admin = loadUsernameAdmin(request.getUsername());
        boolean isValid = request.getPassword().equals(admin.getPassword());

        if (!isValid)throw new UnauthorizedException("Email atau password salah");

        return new LoginResponse( admin.getId() ,admin.getUsername(), "Admin");
    }
    public String registerUser(User request){
        loadRegisterEmailUser(request.getEmail());
        request.setId(UUID.randomUUID().toString());

        User user = new User();
        user.setId(request.getId());
        user.setAddress(request.getAddress());
        user.setEmail(request.getEmail());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setFullName(request.getFullName());
        user.setUsername(request.getUsername());
        user.setPhoneNumber(request.getPhoneNumber());

        User saveUser = userRepository.createUser(user);

        return saveUser.getUsername();
    }

    public LoginResponse loginUser(LoginRequest request) {

        User user = loadEmailUser(request.getUsername());
        boolean isValid = BCrypt.checkpw(request.getPassword(), user.getPassword());

        if (!isValid)throw new UnauthorizedException("Email atau password salah");

        return new LoginResponse( user.getId() ,user.getUsername(), "User");
    }

    public LoginResponse loginPersonalia(Personalia personalia){
        final Personalia personalia1 = personaliaRepository.findPersonalia(personalia);

        if (personalia1 == null)throw new UnauthorizedException("Username atau password salah !");

        return new LoginResponse("1",personalia1.getUsername(), "personalia");
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
}
