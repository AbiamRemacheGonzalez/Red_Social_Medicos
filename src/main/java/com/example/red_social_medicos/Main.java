package com.example.red_social_medicos;

import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.DatabaseUserLoader;

import java.io.File;

public class Main {
    public static void main(String [] args){
        Community community = new Community(1,"ENFERMERIA","DESCRIPCION");
        File xml = community.toXML();
        System.out.println(xml.getName());
    }
}
