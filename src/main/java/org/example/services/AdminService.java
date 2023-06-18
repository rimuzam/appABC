package org.example.services;

import org.example.models.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    List<Admin> findAllAdmin();
    Map<String, String> findEmployeeWhereAdmin();
    boolean deleteAdminAccount(String username);
    boolean deleteAdminByEmployeeId(String employeeId);
}
