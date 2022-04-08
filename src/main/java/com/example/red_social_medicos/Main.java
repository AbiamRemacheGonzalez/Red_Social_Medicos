package com.example.red_social_medicos;

import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.Persistence.MembersEntityFacade;
import com.example.red_social_medicos.Persistence.PostsEntityFacade;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String [] args) throws IOException {
        PostsEntityFacade postsEntityFacade = new PostsEntityFacade();
        Long max = postsEntityFacade.getCountOfPages(1,"");
        for (int i = 1; i <= max; i++) {
            System.out.println("---------------------Página "+i);
            List<Post> searchPosts = postsEntityFacade.searchUserCommunitiesPostsOptimized(1,"",i);
            for (Post post: searchPosts
            ) {
                System.out.println(post.getPostTitle());
            }
        }

    }
    public static LocalDateTime ParseFecha(String fecha) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaDate = null;
        fechaDate = LocalDateTime.parse(fecha,formato);
        return fechaDate;
    }

    private static String getAbsolutePath(){
        String absolutePath = "";
        try {
            absolutePath = new File(".").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return absolutePath;
    }
}
