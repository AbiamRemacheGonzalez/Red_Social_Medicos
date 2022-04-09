package com.example.red_social_medicos.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Aditionaluserinfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userInfoId")
    private int userInfoId;
    @Basic
    @Column(name = "userId")
    private int userId;
    @Basic
    @Column(name = "userAge")
    private int userAge;
    @Basic
    @Column(name = "userSex")
    private int userSex;
    @Basic
    @Column(name = "userNationality")
    private String userNationality;

    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserNationality() {
        return userNationality;
    }

    public void setUserNationality(String userNationality) {
        this.userNationality = userNationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aditionaluserinfo that = (Aditionaluserinfo) o;
        return userInfoId == that.userInfoId && userId == that.userId && userAge == that.userAge && userSex == that.userSex && Objects.equals(userNationality, that.userNationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userInfoId, userId, userAge, userSex, userNationality);
    }
}
