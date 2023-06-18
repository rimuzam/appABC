package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.models.User;
import org.example.repositories.UserRepository;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    private AppDbContext context;

    public UserRepositoryImpl(AppDbContext context) {
        this.context = context;
    }

    private void error(Exception e){
        JOptionPane.showMessageDialog(null, "Error App", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(e.getMessage());
    }

    public List<User> findAllUser(){
        List<User> users = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            String query = "select * from user";
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String username = resultSet.getString("username");
                String fullname = resultSet.getString("fullname");
                String phoneNumber = resultSet.getString("phonenumber");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                users.add(new User(id, username, fullname, phoneNumber, email, password, address));
            }
        } catch (Exception e){
            error(e);
            throw new RuntimeException(e);
        } finally {
            context.closeResources();
        }
        return users;
    }
    public User createUser(User user){
        String query = "insert into user values ('"+ user.getId() +"', '"+ user.getUsername()+"', '"+ user.getFullName() +"', " +
                "'"+ user.getPhoneNumber() +"','"+ user.getAddress() +"', '"+ user.getEmail() +"', '"+ user.getPassword() +"')";
        try {
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
            throw new RuntimeException(e);
        } finally {
            context.closeResources();
        }
        return user;
    }

    public User findUserByEmail(String emailInput){
        User user = null;
        try {
            String query = "select * from user where email = '"+emailInput+"'";
            ResultSet resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String username = resultSet.getString("username");
                String fullname = resultSet.getString("fullname");
                String phoneNumber = resultSet.getString("phonenumber");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                user = new User(id, username, fullname, phoneNumber, email, password, address);
            }
        } catch (Exception e){
            error(e);
            return null;
        } finally {
            context.closeResources();
        }
        return user;
    }

    public User findUserById(String idInput){
        User user = null;
        try {
            String query = "select * from user where id = '"+idInput+"'";
            ResultSet resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String username = resultSet.getString("username");
                String fullname = resultSet.getString("fullname");
                String phoneNumber = resultSet.getString("phonenumber");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                user = new User(id, username, fullname, phoneNumber, email, password, address);
            }
        } catch (Exception e){
            error(e);
            return null;
        } finally {
            context.closeResources();
        }
        return user;
    }

    public User updateUser(User update){
        try {
            String query = "update user set username = '"+ update.getUsername()+"', fullname = '"+update.getFullName()+"', phonenumber = '"+ update.getPhoneNumber()+"', address = '"+ update.getAddress() +"', email = '"+ update.getEmail() +"', password = '"+ update.getPassword() +"' " +
                    "where id = '"+ update.getId()+"'";
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
            return null;
        } finally {
            context.closeResources();
        }
        return update;
    }

    public void deleteUser(String emailUser){
        try {
            String query = "delete from user where email = '"+emailUser+"'";
            context.getStatement().executeUpdate(query);
        } catch (Exception e){
            error(e);
        } finally {
            context.closeResources();
        }
    }
}
