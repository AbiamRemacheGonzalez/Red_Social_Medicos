package com.example.red_social_medicos.Control;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;
import java.nio.file.Paths;

public class XSLTProcessor {
    private final String first_step_xsl_file_path;
    private final String second_step_xsl_file_path;
    private final String intermediate_xml_file_path = "C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xml_files\\intermediate.xml";
    private final TransformerFactory transformerFactory = TransformerFactory.newInstance("org.apache.xalan.processor.TransformerFactoryImpl",null);

    public XSLTProcessor(String first_step_xsl_file_path, String second_step_xsl_file_path) {
        this.first_step_xsl_file_path = first_step_xsl_file_path;
        this.second_step_xsl_file_path = second_step_xsl_file_path;

    }

    public String getTransformation(File xmlFile){
        File first_step_file = first_step_transformation(xmlFile);
        return second_step_transformation(first_step_file);
    }

    private File first_step_transformation(File xmlFile) {
        StreamSource xslStreamSource = new StreamSource(Paths.get(first_step_xsl_file_path).toAbsolutePath().toFile());
        StreamSource xmlStreamSource = new StreamSource(xmlFile);
        File result = Paths.get(intermediate_xml_file_path).toAbsolutePath().toFile();
        StreamResult xmlStreamResult = new StreamResult(result);

        executeTransformation(xslStreamSource,xmlStreamSource,xmlStreamResult);

        return result;
    }

    private String second_step_transformation(File first_step_file) {
        StreamSource xslStreamSource = new StreamSource(Paths.get(second_step_xsl_file_path).toAbsolutePath().toFile());
        StreamSource xmlStreamSource = new StreamSource(first_step_file);
        StringWriter writer = new StringWriter();
        StreamResult StringStreamResult = new StreamResult(writer);

        executeTransformation(xslStreamSource,xmlStreamSource,StringStreamResult);

        return writer.toString();
    }

    private void executeTransformation(StreamSource xslStreamSource, StreamSource xmlStreamSource, StreamResult StreamResult) {
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer(xslStreamSource);
            transformer.transform(xmlStreamSource,StreamResult);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
