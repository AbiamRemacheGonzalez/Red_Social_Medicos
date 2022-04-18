package com.example.red_social_medicos.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Moderator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "moderatoId")
    private int moderatoId;
    @Basic
    @Column(name = "userId")
    private int userId;
    @Basic
    @Column(name = "communityId")
    private int communityId;

    public int getModeratoId() {
        return moderatoId;
    }

    public void setModeratoId(int moderatoId) {
        this.moderatoId = moderatoId;
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
        Moderator moderator = (Moderator) o;
        return moderatoId == moderator.moderatoId && userId == moderator.userId && communityId == moderator.communityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moderatoId, userId, communityId);
    }
}
