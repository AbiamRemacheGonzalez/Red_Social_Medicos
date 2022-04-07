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
        "userId",
        "userName",
        "userEmail",
        "userPassword"
})
@XmlRootElement(name = "User")
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userId")
    @XmlElement(name = "userId", required = true)
    private int userId;
    @Basic
    @Column(name = "userName")
    @XmlElement(name = "userName", required = true)
    private String userName;
    @Basic
    @Column(name = "userPassword")
    @XmlElement(name = "userPassword", required = true)
    private String userPassword;
    @Embedded
    @XmlElement(name = "userEmail", required = true)
    private EmailDatabaseEntity userEmail;

    public void setEmailDatabaseEntity(EmailDatabaseEntity emailDatabaseEntity) {
        this.userEmail = emailDatabaseEntity;
    }

    public EmailDatabaseEntity getUserEmail() {
        return userEmail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(userName, user.userName) && Objects.equals(userPassword, user.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userPassword);
    }

    public File toXML() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(com.example.red_social_medicos.Model.User.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
        File userFile = new File("C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xml_files\\usuario.xml");
        jaxbMarshaller.marshal(this,userFile);
        return userFile;
    }
}
