package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Persistence.DatabaseCommunityLoader;
import com.example.red_social_medicos.Persistence.DatabasePostLoader;
import com.example.red_social_medicos.Persistence.DatabaseUserLoader;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExploreCommunitiesCommand extends FrontCommand{
    DatabaseCommunityLoader databaseCommunityLoader = new DatabaseCommunityLoader();
    @Override
    public void process() throws ServletException, IOException, JAXBException {
        getCommunitiesDetails();
        forward("/communities_main_page.jsp");
    }

    private void getCommunitiesDetails() {
        response.setContentType("text/html");
        List<Community> communities = databaseCommunityLoader.getAllCommunities();
        session.setAttribute("communities",communities);
    }
}
