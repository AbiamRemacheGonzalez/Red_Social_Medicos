package com.example.red_social_medicos.View;

import com.example.red_social_medicos.Model.Post;

import java.util.List;

public interface PostLoader {
    public Post getPostId(int postId);
    //Posts de las comunidades en las que un usuario está suscrito.
    public List<Post> getMyCommunitiesPosts(int userId);
    //Posts de una comunidad concreta.
    public List<Post> getCommunityPosts(int communityId);
    //Post de todas las comunidades.
    public List<Post> getAllCommunitiesPosts();
}
