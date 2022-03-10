package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Persistence.DatabasePostLoader;
import com.example.red_social_medicos.Persistence.DatabaseUserLoader;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public class ExploreCommunitiesCommand extends FrontCommand{
    private DatabaseUserLoader databaseUserLoader = new DatabaseUserLoader();
    private DatabasePostLoader databasePostLoader = new DatabasePostLoader();
    private final String first_step_xsl_file_path ="C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\post_first_step.xsl";
    private final String second_step_xsl_file_path="C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\post_second_step.xsl";

    @Override
    public void process() throws ServletException, IOException, JAXBException {
        getCommunitiesDetails();
        forward("/communities_main");
    }

    private void getCommunitiesDetails() {
    }
}
