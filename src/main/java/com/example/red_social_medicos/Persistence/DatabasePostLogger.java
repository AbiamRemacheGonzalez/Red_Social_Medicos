package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.View.PostLogger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePostLogger implements PostLogger {
    private Statement statement;
    private Connection connection;


    public DatabasePostLogger() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void savePost(Post post) {
        try {
            System.out.println(post.getCreationDate());
            String sql = "INSERT INTO posts(communityId,userId,postTitle,postDescription,creationDate,postEvaluation) " +
                    "VALUES ("+post.getCommunityId()+","+post.getUserId()+",\""+post.getPostTitle()+"\",\""+post.getPostDescription()+"\",\""+post.getCreationDate()+"\","+post.getPostEvaluation()+");";
            System.out.println(sql);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
