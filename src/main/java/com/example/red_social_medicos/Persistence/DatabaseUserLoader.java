package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.View.UserLoader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUserLoader implements UserLoader {
    private Connection connection;
    private Statement statement;

    public DatabaseUserLoader() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User loadUser(String userEmail, String password) {
        User loadedUser = null;
        try {
            String sql = "SELECT * FROM users WHERE userEmail='"+userEmail+"' and userPassword='"+password+"'";
            statement.execute(sql);
            ResultSet r = statement.getResultSet();
            while(r.next()){
                loadedUser = new User(Integer.parseInt(r.getString("userId")),r.getString("userName"),r.getString("userEmail"),r.getString("userPassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loadedUser;
    }

    @Override
    public User loadUser(int userId) {
        User loadedUser = null;
        try {
            String sql = "SELECT * FROM users WHERE userId='"+userId+"'";
            statement.execute(sql);
            ResultSet r = statement.getResultSet();
            while(r.next()){
                loadedUser = new User(userId,r.getString("userName"),r.getString("userEmail"),r.getString("userPassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loadedUser;
    }
}
