package com.example.red_social_medicos.Model;

import javax.persistence.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "communityId",
        "communityName",
        "communityDescription"
})
@XmlRootElement(name = "Community")
@Entity
public class Community {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "communityId")
    @XmlElement(name = "communityId", required = true)
    private int communityId;
    @Basic
    @Column(name = "communityName")
    @XmlElement(name = "communityName", required = true)
    private String communityName;
    @Basic
    @Column(name = "communityDescription")
    @XmlElement(name = "communityDescription", required = true)
    private String communityDescription;

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityDescription() {
        return communityDescription;
    }

    public void setCommunityDescription(String communityDescription) {
        this.communityDescription = communityDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Community community = (Community) o;
        return communityId == community.communityId && Objects.equals(communityName, community.communityName) && Objects.equals(communityDescription, community.communityDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(communityId, communityName, communityDescription);
    }

    public File toXML(){
        File communityFile = new File("C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xml_files\\community.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(com.example.red_social_medicos.Model.Community.class);
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
