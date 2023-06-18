package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.models.Admin;
import org.example.repositories.AdminRepository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {
    private AppDbContext context;
    public AdminRepositoryImpl(AppDbContext context){
        this.context = context;
    }

    private void error(Exception e){
        JOptionPane.showMessageDialog(null, "Error App", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(e.getMessage());
        throw new RuntimeException(e.getMessage());
    }

    public Admin createAdmin(Admin admin) {

        String query = "insert into admin values ('"+ admin.getId() +"', '"+ admin.getUsername()+"', '"+ admin.getPassword() +"', '"+admin.getEmployee_id()+"')";
        try {
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
        return admin;
    }

    public Admin findAdminByEmployeeId(String usernameIpt){
        Admin admin = null;
        ResultSet resultSet = null;
        try{
            String query = "select * from admin where username = '"+usernameIpt+"'";
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String employee_id = resultSet.getString("employee_id");
                admin = new Admin(id, username, password, employee_id);
            }
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
        return admin;
    }

    public List<Admin> findAllAdmin(){
        List<Admin> admins = new ArrayList<>();
        String query = "select a.id, a.username, a.password, e.name, e.id as employee_id\n" +
                "from admin a\n" +
                "join employee e on e.id = a.employee_id";
        ResultSet resultSet = null;
        try{
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("employee_id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String employeeId = resultSet.getString("name");
                admins.add(new Admin(id, username, password, employeeId));
            }
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
        return admins;
    }

    public boolean deleteAdminAccount(String username){
        String query = "delete from admin where username = '"+username+"'";
        try{
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
        return true;
    }

    public boolean deleteAdminAccountByEmployeeId(String employeeId){
        String query = "delete from admin where employee_id = '"+employeeId+"'";
        try{
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
        return true;
    }
}
