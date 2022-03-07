package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.View.CommunityLoader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCommunityLoader implements CommunityLoader {

    private Statement statement;
    private Connection connection;

    public DatabaseCommunityLoader() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Community getCommunity(int communityId) {
        Community loadedCommunity = null;
        try {
            String sql = "SELECT * FROM communities WHERE communityId='"+communityId+"'";
            statement.execute(sql);
            ResultSet r = statement.getResultSet();
            while(r.next()){
                loadedCommunity = new Community(communityId,r.getString("communityName"),r.getString("communityDescription"));
                //Añadir por ejemplo los miembros y los posts
                //loadedCommunity.setCommunityMembers();
                //loadedCommunity.setCommunityPosts();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loadedCommunity;
    }

    @Override
    public List<Community> getAllCommunities() {
        List<Community> communities = new ArrayList<>();
        try {
            String sql = "SELECT * FROM communities";
            statement.execute(sql);
            ResultSet r = statement.getResultSet();
            while(r.next()){
                Community loadedCommunity = new Community(Integer.parseInt(r.getString("communityId")),r.getString("communityName"),r.getString("communityDescription"));
                communities.add(loadedCommunity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return communities;
    }
}