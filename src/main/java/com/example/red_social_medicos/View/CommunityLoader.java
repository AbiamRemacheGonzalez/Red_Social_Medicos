package com.example.red_social_medicos.View;

import com.example.red_social_medicos.Model.Community;

import java.util.List;

public interface CommunityLoader {
    public Community getCommunity(int communityId);
    public List<Community> getAllCommunities();
}
