package org.example.repositories.impl;

import org.example.database.AppDbContext;
import org.example.models.Personalia;
import org.example.repositories.PersonaliaRepository;

import javax.swing.*;
import java.sql.ResultSet;

public class PersonaliaRepositoryImpl implements PersonaliaRepository {
    private AppDbContext context;
    public PersonaliaRepositoryImpl(AppDbContext context){
        this.context = context;
    }

    private void error(Exception e){
        JOptionPane.showMessageDialog(null, "Error App", "Error", JOptionPane.ERROR_MESSAGE);
        System.out.println(e.getMessage());
    }
    public Personalia findPersonalia(Personalia personalia){
        String query = "select * from personalia where username = '"+personalia.getUsername()+"' and password = '"+personalia.getPassword()+"'";
        ResultSet resultSet = null;
        Personalia find = null;
        try {
            resultSet = context.setResultSet(context.getStatement().executeQuery(query));
            while (resultSet.next()){
                String usename = resultSet.getString("username");
                String password = resultSet.getString("password");
                find = new Personalia(usename, password);
            }
        } catch (Exception e){
            error(e);
            throw new RuntimeException(e);
        } finally {
            context.closeResources();
        }
        return find;
    }
}
