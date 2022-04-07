package com.example.red_social_medicos.Model.Old;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "postId",
        "communityId",
        "userId",
        "postTitle",
        "postDescription",
        "creationDate",
        "postEvaluation",
        "comments"
})
@XmlRootElement(name = "Post")
public class Post {
    @XmlElement(name = "postId", required = true)
    private int postId;
    @XmlElement(name = "communityId", required = true)
    private int communityId;
    @XmlElement(name = "userId", required = true)
    private int userId;
    @XmlElement(name = "postTitle", required = true)
    private String postTitle;
    @XmlElement(name = "postDescription", required = true)
    private String postDescription;
    @XmlElement(name = "creationDate", required = true)
    private LocalDateTime creationDate;
    @XmlElement(name = "postEvaluation", required = true)
    private int postEvaluation =0;
    @XmlElementWrapper(name = "comments")
    @XmlElement(name = "Comment")
    private List<Comment> comments;

    public Post() {
    }

    public Post(int communityId, int userId, String postTitle, String postDescription) {
        this.communityId = communityId;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.creationDate = LocalDateTime.now();
        this.postEvaluation = 0;
    }

    public Post(int postId, int communityId, int userId, String postTitle, String postDescription, LocalDateTime creationDate, int postEvaluation) {
        this.postId = postId;
        this.communityId = communityId;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.creationDate = creationDate;
        this.postEvaluation = postEvaluation;
    }

    public int getPostId() {
        return postId;
    }

    public int getCommunityId() {
        return communityId;
    }

    public int getUserId() {
        return userId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setPostEvaluation(int postEvaluation) {
        this.postEvaluation = postEvaluation;
    }

    public int getPostEvaluation() {
        return postEvaluation;
    }

    public File toXML(){
        File postFile = new File("C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xml_files\\post.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Post.class);
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
