package com.example.red_social_medicos.Model.Old;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "communityId",
        "communityName",
        "communityDescription",
        "communityMembers",
        "communityPosts"
})
@XmlRootElement(name = "Community")
public class Community {
    @XmlElement(name = "communityId", required = true)
    private int communityId;
    @XmlElement(name = "communityName", required = true)
    private String communityName;
    @XmlElement(name = "communityDescription", required = true)
    private String communityDescription;
    @XmlElementWrapper(name = "communityMembers")
    @XmlElement(name = "User")
    private List<User> communityMembers;
    @XmlElementWrapper(name = "communityPosts")
    @XmlElement(name = "Post")
    private List<Post> communityPosts;

    public Community() {
    }

    public Community(int communityId, String communityName, String communityDescription) {
        this.communityId = communityId;
        this.communityName = communityName;
        this.communityDescription = communityDescription;
        this.communityMembers = new ArrayList<>();
        this.communityPosts = new ArrayList<>();
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

    public File toXML(){
        File communityFile = new File("C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xml_files\\community.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Community.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
            jaxbMarshaller.marshal(this,communityFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return communityFile;
    }
}
