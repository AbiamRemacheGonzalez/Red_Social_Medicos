package com.example.red_social_medicos.Model;

import javax.persistence.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.sql.Timestamp;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "postId",
        "communityId",
        "userId",
        "postTitle",
        "postDescription",
        "creationDate",
        "postEvaluation"
})
@XmlRootElement(name = "Post")
@Entity
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "postId")
    @XmlElement(name = "postId", required = true)
    private int postId;
    @Basic
    @Column(name = "communityId")
    @XmlElement(name = "communityId", required = true)
    private int communityId;
    @Basic
    @Column(name = "userId")
    @XmlElement(name = "userId", required = true)
    private int userId;
    @Basic
    @Column(name = "postTitle")
    @XmlElement(name = "postTitle", required = true)
    private String postTitle;
    @Basic
    @Column(name = "postDescription")
    @XmlElement(name = "postDescription", required = true)
    private String postDescription;
    @Basic
    @Column(name = "creationDate")
    @XmlElement(name = "creationDate", required = true)
    private Timestamp creationDate;
    @Basic
    @Column(name = "postEvaluation")
    @XmlElement(name = "postEvaluation", required = true)
    private int postEvaluation;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public int getPostEvaluation() {
        return postEvaluation;
    }

    public void setPostEvaluation(int postEvaluation) {
        this.postEvaluation = postEvaluation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postId == post.postId && communityId == post.communityId && userId == post.userId && postEvaluation == post.postEvaluation && Objects.equals(postTitle, post.postTitle) && Objects.equals(postDescription, post.postDescription) && Objects.equals(creationDate, post.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, communityId, userId, postTitle, postDescription, creationDate, postEvaluation);
    }

    public File toXML(){
        File postFile = new File("C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xml_files\\post.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(com.example.red_social_medicos.Model.Post.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
            jaxbMarshaller.marshal(this,postFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return postFile;
    }
}
