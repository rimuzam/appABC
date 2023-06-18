package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AppDbContext {
    private ResultSet resultSet;

    private final String url = "jdbc:mysql://localhost:3306/futsaldb";
    private final String user = "root";
    private final String driver = "com.mysql.jdbc.Driver";

    public ResultSet getResultSet() {
        return resultSet;
    }
    public ResultSet setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
        return resultSet;
    }
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, "");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public Statement getStatement(){
        Statement statement = null;
        //Connection connection = null;
        try {
            //Class.forName(driver);
            //connection = DriverManager.getConnection(url, user, "");
            statement = getConnection().createStatement();
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return statement;
    }
    public void closeResources() {
        try {
            getResultSet().close();
            getConnection().close();
            getStatement().close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
