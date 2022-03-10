package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.DatabaseUserLogger;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public class LeaveCommunityCommand extends FrontCommand{
    DatabaseUserLogger databaseUserLogger = new DatabaseUserLogger();
    @Override
    public void process() throws ServletException, IOException, JAXBException {
        User loadedUser = (User) session.getAttribute("loadedUser");
        Community community= (Community) session.getAttribute("community");
        databaseUserLogger.leaveCommunity(loadedUser.getUserId(), community.getCommunityId());
        forward("/community_main.jsp");
    }
}
