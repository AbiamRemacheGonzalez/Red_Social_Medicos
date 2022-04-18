package com.example.red_social_medicos.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "commentId")
    private int commentId;
    @Basic
    @Column(name = "postId")
    private int postId;
    @Basic
    @Column(name = "userId")
    private int userId;
    @Basic
    @Column(name = "comment")
    private String comment;
    @Basic
    @Column(name = "creationDate")
    private Timestamp creationDate;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment1 = (Comment) o;
        return commentId == comment1.commentId && postId == comment1.postId && userId == comment1.userId && Objects.equals(comment, comment1.comment) && Objects.equals(creationDate, comment1.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, userId, comment, creationDate);
    }
}
