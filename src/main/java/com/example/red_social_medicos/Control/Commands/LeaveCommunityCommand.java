package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Model.Member;
import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.MembersEntityFacade;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public class LeaveCommunityCommand extends FrontCommand{
    private MembersEntityFacade membersEntityFacade = new MembersEntityFacade();
    @Override
    public void process() throws ServletException, IOException, JAXBException {
        User loadedUser = (User) session.getAttribute("loadedUser");
        Community community= (Community) session.getAttribute("community");
        membersEntityFacade.removeByUserAndCommunityId(loadedUser.getUserId(),community.getCommunityId());
        session.setAttribute("userIsMember", false);
        forward("/community_main.jsp");
    }
}
