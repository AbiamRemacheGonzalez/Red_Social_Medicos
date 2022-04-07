package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.Community;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CommunitiesEntityFacade extends AbstractFacade<Community>{

    private final EntityManager em = EntityManagerGenerator.getEntityManager("entities");

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommunitiesEntityFacade() {super(Community.class);}

    public List<Community> findByUserId(int userId){
        List<Community> allCommunities = this.findAll();
        List<Community> userCommunities = new ArrayList<>();
        MembersEntityFacade membersEntityFacade = new MembersEntityFacade();
        for (Community community: allCommunities) {
            if(membersEntityFacade.isMemberOfACommunity(userId,community.getCommunityId())){
                userCommunities.add(community);
            }
        }
       return userCommunities;
    }
}
