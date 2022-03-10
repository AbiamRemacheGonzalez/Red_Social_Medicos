package com.example.red_social_medicos.Control.Commands;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public class UnknownCommand extends FrontCommand{
    @Override
    public void process() throws ServletException, IOException, JAXBException {
        forward("/unkown_command.jsp");
    }
}
