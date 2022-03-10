package com.example.red_social_medicos.Control;

import com.example.red_social_medicos.Control.Commands.FrontCommand;
import com.example.red_social_medicos.Control.Commands.UnknownCommand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.bind.JAXBException;
import java.io.IOException;

@WebServlet(name = "FrontControllerServlet", value = "/FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        FrontCommand command = getCommand(request);
        response.setContentType("text/html");
        HttpSession session = request.getSession(true);
        command.init(this.getServletContext(),request,response,session);
        try {
            command.process();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private FrontCommand getCommand(HttpServletRequest request) {
        FrontCommand f = null;
        try {
            f = (FrontCommand) getCommandClass(request).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return f;
    }

    private Class getCommandClass(HttpServletRequest request) {
        Class result;
        final String command ="com.example.red_social_medicos.Control.Commands." + (String) request.getParameter("command");
        try {
            result = Class.forName(command);
        } catch (ClassNotFoundException e) {
            result = UnknownCommand.class;
        }
        return result;
    }
}
