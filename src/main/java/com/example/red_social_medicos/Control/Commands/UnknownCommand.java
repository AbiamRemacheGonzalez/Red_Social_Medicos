package com.example.red_social_medicos.Control.Commands;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class UnknownCommand extends FrontCommand{
    private final String log_error_file_path = "C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\error_log";
    @Override
    public void process() throws ServletException, IOException, JAXBException {
        writeLogError("An unknown command has been executed.");
        forward("/unkown_command.jsp");
    }

    private void writeLogError(String error) {
        File file = new File(log_error_file_path);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.newLine();
            bw.write(LocalDateTime.now()+": "+error);
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
