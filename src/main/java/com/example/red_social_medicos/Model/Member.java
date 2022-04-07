package com.example.red_social_medicos.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "memberId")
    private int memberId;
    @Basic
    @Column(name = "userId")
    private int userId;
    @Basic
    @Column(name = "communityId")
    private int communityId;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId && userId == member.userId && communityId == member.communityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, userId, communityId);
    }
}
