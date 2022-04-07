package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Persistence.CommunitiesEntityFacade;
import com.example.red_social_medicos.Persistence.MembersEntityFacade;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExploreCommunitiesCommand extends FrontCommand{
    CommunitiesEntityFacade communitiesEntityFacade = new CommunitiesEntityFacade();
    MembersEntityFacade membersEntityFacade = new MembersEntityFacade();
    @Override
    public void process() throws ServletException, IOException, JAXBException {
        getCommunitiesDetails();
        forward("/communities_main_page.jsp");
    }

    private void getCommunitiesDetails() {
        response.setContentType("text/html");
        List<Community> communities = communitiesEntityFacade.findAll();
        List<Long> numberOfMembers = new ArrayList<>();
        for (Community community: communities) {
            numberOfMembers.add(membersEntityFacade.getCountOfMembers(community.getCommunityId()));
        }

        session.setAttribute("communities",communities);
        session.setAttribute("numberOfMembers", numberOfMembers);
    }
}
