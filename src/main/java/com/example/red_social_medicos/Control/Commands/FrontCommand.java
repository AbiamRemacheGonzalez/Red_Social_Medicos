package com.example.red_social_medicos.Control.Commands;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public abstract class FrontCommand {
    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;


    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        this.context = context;
        this.request = request;
        this.response = response;
        this.session = session;
    }

    abstract public void process() throws ServletException, IOException, JAXBException;

    public void forward(String target) throws ServletException, IOException {
        RequestDispatcher dp = context.getRequestDispatcher(target);
        dp.forward(request,response);
    }
}
