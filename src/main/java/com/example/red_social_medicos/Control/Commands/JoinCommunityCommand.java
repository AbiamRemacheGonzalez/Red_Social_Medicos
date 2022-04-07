package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.Member;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.MembersEntityFacade;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public class JoinCommunityCommand extends FrontCommand {
    private MembersEntityFacade membersEntityFacade = new MembersEntityFacade();
    @Override
    public void process() throws ServletException, IOException, JAXBException {
        User loadedUser = (User) session.getAttribute("loadedUser");
        Community community= (Community) session.getAttribute("community");
        Member newMember = new Member();
        newMember.setCommunityId(community.getCommunityId());
        newMember.setUserId(loadedUser.getUserId());
        membersEntityFacade.create(newMember);
        session.setAttribute("userIsMember", true);
        forward("/community_main.jsp");
    }
}
