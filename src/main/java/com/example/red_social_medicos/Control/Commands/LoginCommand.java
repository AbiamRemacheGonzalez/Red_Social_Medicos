package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.DatabaseUserLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public class LoginCommand extends FrontCommand{
    private DatabaseUserLoader databaseUserLoader = new DatabaseUserLoader();
    @Override
    public void process() throws ServletException, IOException, JAXBException {
        if (checkLoginValues()){
            forward("/main_page.jsp");
        }else{
            forward("/login_error.jsp");
        }
    }

    private boolean checkLoginValues() {
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        User loadedUser = databaseUserLoader.loadUser(userEmail,userPassword);
        if(loadedUser!=null) {
            response.setContentType("text/html");
            HttpSession session = request.getSession(true);
            session.setAttribute("loadedUser",loadedUser);
            return true;
        }
        return false;
    }
}
