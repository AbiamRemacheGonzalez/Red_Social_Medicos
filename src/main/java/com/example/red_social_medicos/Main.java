package com.example.red_social_medicos;

import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.Persistence.DatabaseCommunityLoader;
import com.example.red_social_medicos.Persistence.DatabasePostLogger;

import javax.ejb.Local;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String [] args){
        String fecha = "2022-03-08 00:02:54";
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime notnow = ParseFecha(fecha);
        System.out.println(localDateTime.toString());
        System.out.println(notnow.toString());
        DatabasePostLogger databasePostLogger = new DatabasePostLogger();
        Post newPost = new Post(4,2,"Ojos rojos y llorosos","En general, los ojos rojos son causados por alergia, fatiga ocular, uso exagerado de lentes de contacto o infecciones oculares comunes, tales como conjuntivitis. No obstante, el enrojecimiento ocular algunas veces puede ser signo de un trastorno o enfermedad más grave en los ojos; la uveítis o el glaucoma, por ejemplo.");
        databasePostLogger.savePost(newPost);
    }
    public static LocalDateTime ParseFecha(String fecha) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaDate = null;
        fechaDate = LocalDateTime.parse(fecha,formato);
        return fechaDate;
    }
}
