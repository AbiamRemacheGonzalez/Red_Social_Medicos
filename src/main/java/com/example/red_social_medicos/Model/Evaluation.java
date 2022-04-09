package com.example.red_social_medicos.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Evaluation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "evaluationId")
    private int evaluationId;
    @Basic
    @Column(name = "postId")
    private int postId;
    @Basic
    @Column(name = "userId")
    private int userId;

    public int getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(int evaluationId) {
        this.evaluationId = evaluationId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evaluation that = (Evaluation) o;
        return evaluationId == that.evaluationId && postId == that.postId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(evaluationId, postId, userId);
    }
}
