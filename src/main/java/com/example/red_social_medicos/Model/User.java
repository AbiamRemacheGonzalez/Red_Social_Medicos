package com.example.red_social_medicos.Model;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "userId",
        "userName",
        "userEmail",
        "userPassword"
})
@XmlRootElement(name = "User")
public class User {
    @XmlElement(name = "userId", required = true)
    private Integer userId;
    @XmlElement(name = "userName", required = true)
    private String userName;
    @XmlElement(name = "userEmail", required = true)
    private String userEmail;
    @XmlElement(name = "userPassword", required = true)
    private String userPassword;

    public User() {
    }

    public User(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public User(Integer userId, String userName, String userEmail, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {return userPassword;}

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public File toXML() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        File userFile = new File("C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xml_files\\usuario.xml");
        jaxbMarshaller.marshal(this,userFile);
        return userFile;
    }
}
