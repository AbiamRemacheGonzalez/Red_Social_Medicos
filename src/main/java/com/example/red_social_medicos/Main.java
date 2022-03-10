package com.example.red_social_medicos;

import com.example.red_social_medicos.Persistence.DatabaseCommunityLoader;

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

    }
    public static LocalDateTime ParseFecha(String fecha) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaDate = null;
        fechaDate = LocalDateTime.parse(fecha,formato);
        return fechaDate;
    }
}
