package org.example.services;

import org.example.dtos.LoginRequest;
import org.example.dtos.LoginResponse;
import org.example.models.Admin;
import org.example.models.Employee;
import org.example.models.Personalia;
import org.example.models.User;

import java.util.List;
import java.util.Map;

public interface AuthService {
    String registerUser(User request);
    LoginResponse loginUser(LoginRequest request);
    String registerAdmin(Admin request);
    LoginResponse loginAdmin(LoginRequest request);
    LoginResponse loginPersonalia(Personalia personalia);
    List<Admin> findAllAdmin();
    Map<String, String> findEmployeeWhereAdmin();
}
