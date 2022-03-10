package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.View.PostLoader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DatabasePostLoader implements PostLoader {
    private Statement statement;
    private Connection connection;


    public DatabasePostLoader() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            connection = databaseConnection.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Post getPostId(int postId) {
        Post loadedPost = null;
        try {
            String sql = "SELECT * FROM posts WHERE post Id='"+postId+"'";
            statement.execute(sql);
            ResultSet r = statement.getResultSet();
            while(r.next()){
                loadedPost = new Post(postId,
                        Integer.parseInt(r.getString("communityId")),
                        Integer.parseInt(r.getString("userId")),
                        r.getString("postTitle"),
                        r.getString("postDescription"),
                        ParseFecha(r.getString("creationDate")),
                        Integer.parseInt(r.getString("postEvaluation")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loadedPost;
    }

    @Override
    public List<Post> getMyCommunitiesPosts(int userId) {
        DatabaseCommunityLoader databaseCommunityLoader= new DatabaseCommunityLoader();
        List<Community> userCommunities = databaseCommunityLoader.getUserCommunities(userId);
        List<Post> userCommunitiesPosts = new ArrayList<>();
        for (Community userCommunity: userCommunities) {
            List<Post> userCommunityPosts = getCommunityPosts(userCommunity.getCommunityId());
            userCommunitiesPosts.addAll(userCommunityPosts);
        }
        return userCommunitiesPosts;
    }

    @Override
    public List<Post> getCommunityPosts(int communityId) {
        List<Post> userPosts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM posts WHERE communityId='"+communityId+"'";
            statement.execute(sql);
            ResultSet r = statement.getResultSet();
            while(r.next()){
                Post loadedPost = new Post(Integer.parseInt(r.getString("postId")),
                        Integer.parseInt(r.getString("communityId")),
                        Integer.parseInt(r.getString("userId")),
                        r.getString("postTitle"),
                        r.getString("postDescription"),
                        ParseFecha(r.getString("creationDate")),
                        Integer.parseInt(r.getString("postEvaluation")));
                userPosts.add(loadedPost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userPosts;
    }

    @Override
    public List<Post> getAllCommunitiesPosts() {
        List<Post> userPosts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM posts";
            statement.execute(sql);
            ResultSet r = statement.getResultSet();
            while(r.next()){
                Post loadedPost = new Post(Integer.parseInt(r.getString("postId")),
                        Integer.parseInt(r.getString("communityId")),
                        Integer.parseInt(r.getString("userId")),
                        r.getString("postTitle"),
                        r.getString("postDescription"),
                        ParseFecha(r.getString("creationDate")),
                        Integer.parseInt(r.getString("postEvaluation")));
                userPosts.add(loadedPost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userPosts;
    }
    public LocalDateTime ParseFecha(String fecha) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaDate = null;
        fechaDate = LocalDateTime.parse(fecha,formato);
        return fechaDate;
    }
}
