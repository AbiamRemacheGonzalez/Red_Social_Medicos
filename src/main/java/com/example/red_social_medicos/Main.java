package com.example.red_social_medicos;

import com.example.red_social_medicos.Control.XSLTProcessor;
import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.Persistence.DatabaseCommunityLoader;
import com.example.red_social_medicos.Persistence.DatabasePostLogger;

import javax.ejb.Local;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String [] args) throws IOException {
        String fecha = "2022-03-08 00:02:54";
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime notnow = ParseFecha(fecha);
        System.out.println(localDateTime.toString());
        System.out.println(notnow.toString());
        DatabasePostLogger databasePostLogger = new DatabasePostLogger();
        Post newPost = new Post(4,2,"Ojos rojos y llorosos","En general, los ojos rojos son causados por alergia, fatiga ocular, uso exagerado de lentes de contacto o infecciones oculares comunes, tales como conjuntivitis. No obstante, el enrojecimiento ocular algunas veces puede ser signo de un trastorno o enfermedad más grave en los ojos; la uveítis o el glaucoma, por ejemplo.");
        databasePostLogger.savePost(newPost);
        String first_step_xsl_file_path ="C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\post_first_step.xsl";
        String second_step_xsl_file_path=getAbsolutePath()+"\\src\\main\\webapp\\xsl_files\\post_second_step.xsl";
        XSLTProcessor xsltProcessor = new XSLTProcessor(first_step_xsl_file_path,second_step_xsl_file_path);
        String res = xsltProcessor.getTransformation(newPost.toXML());
        String dir = getAbsolutePath()+"\\src\\main\\webapp\\xsl_files\\post_second_step.xsl";
        System.out.println(res);
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
