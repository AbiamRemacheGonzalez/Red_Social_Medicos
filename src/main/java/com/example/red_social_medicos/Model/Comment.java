package com.example.red_social_medicos.Model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "postId",
        "message",
})
@XmlRootElement(name = "Comment")
public class Comment {
    @XmlElement(name = "postId", required = true)
    private int postId;
    @XmlElement(name = "message", required = true)
    private String message;

    public Comment() {
    }

    public Comment(String message) {
        this.message = message;
    }

    public Comment(int postId, String message) {
        this.postId = postId;
        this.message = message;
    }

    public File toXML(){
        File commentFile = new File("C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xml_files\\comment.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Post.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
            jaxbMarshaller.marshal(this,commentFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return commentFile;
    }
}
