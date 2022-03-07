package com.example.red_social_medicos.Model;

import java.util.List;

public class Community {
    private final int communityId;
    private final String communityName;
    private final String communityDescription;
    private List<User> communityMembers;
    private List<Post> communityPosts;

    public Community(int communityId, String communityName, String communityDescription) {
        this.communityId = communityId;
        this.communityName = communityName;
        this.communityDescription = communityDescription;
    }

    public int getCommunityId() {
        return communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public String getCommunityDescription() {
        return communityDescription;
    }

    public void setCommunityMembers(List<User> communityMembers) {
        this.communityMembers = communityMembers;
    }

    public void setCommunityPosts(List<Post> communityPosts) {
        this.communityPosts = communityPosts;
    }
}
