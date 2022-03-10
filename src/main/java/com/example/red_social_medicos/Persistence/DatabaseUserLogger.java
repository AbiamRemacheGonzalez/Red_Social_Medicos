package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.View.UserLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUserLogger implements UserLogger {
    private Connection connection;
    private Statement statement;

    public DatabaseUserLogger() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void joinCommunity(int userId, int communityId) {
        try {
            String sql = "INSERT INTO members(userId,communityId) VALUES ("+userId+","+communityId+");";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leaveCommunity(int userId, int communityId) {
        try {
            String sql = "DELETE FROM members WHERE userId ="+userId+" AND communityId="+communityId+";";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
