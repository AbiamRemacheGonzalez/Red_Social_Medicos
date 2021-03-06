package com.example.red_social_medicos;

import com.example.red_social_medicos.Model.Comment;
import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.Persistence.CommentsEntityFacade;
import com.example.red_social_medicos.Persistence.MembersEntityFacade;
import com.example.red_social_medicos.Persistence.PostsEntityFacade;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String [] args) throws IOException {
        LocalDateTime local = ParseFecha("2022-03-15 00:02:54");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(local.minusDays(5));
        CommentsEntityFacade commentsEntityFacade = new CommentsEntityFacade();
        Comment comment = (Comment) commentsEntityFacade.find(1);
        commentsEntityFacade.updateComment(comment, "Cambiando comentario");

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
