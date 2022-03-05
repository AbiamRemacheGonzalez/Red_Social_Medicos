package com.example.red_social_medicos;

import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.DatabaseUserLoader;

public class Main {
    public static void main(String [] args){
        DatabaseUserLoader databaseUserLoader = new DatabaseUserLoader();
        User loadedUser = databaseUserLoader.loadUser("abiam@gmail.com","1234");
        if(loadedUser==null){
            System.out.println("nulo");
        }else{
            System.out.printf(loadedUser.getUserName());
        }
    }
}
