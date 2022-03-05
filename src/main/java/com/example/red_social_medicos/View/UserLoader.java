package com.example.red_social_medicos.View;

import com.example.red_social_medicos.Model.User;

public interface UserLoader {
    public User loadUser(String userEmail, String password);
    public User loadUser(int userId);
}
