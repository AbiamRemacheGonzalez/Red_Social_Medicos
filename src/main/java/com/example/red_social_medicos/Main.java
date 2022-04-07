package com.example.red_social_medicos;

import com.example.red_social_medicos.Model.Member;
import com.example.red_social_medicos.Persistence.MembersEntityFacade;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String [] args) throws IOException {
        MembersEntityFacade membersEntityFacade = new MembersEntityFacade();
        membersEntityFacade.removeByUserAndCommunityId(1,2);


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
