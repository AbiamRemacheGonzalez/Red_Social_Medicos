package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Model.Aditionaluserinfo;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.AditionalUsersInfoEntityFacade;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public class EditAdditionalInfoCommand extends FrontCommand{
    AditionalUsersInfoEntityFacade aditionalUsersInfoEntityFacade = new AditionalUsersInfoEntityFacade();
    @Override
    public void process() throws ServletException, IOException, JAXBException {
        User loadedUser = loadedUser = (User) session.getAttribute("loadedUser");
        Integer age = Integer.parseInt(request.getParameter("age"));
        Integer sex = Integer.parseInt(request.getParameter("sex"));
        String nationality = request.getParameter("nationality");

        Aditionaluserinfo aditionaluserinfo = new Aditionaluserinfo();
        aditionaluserinfo.setUserInfoId(aditionalUsersInfoEntityFacade.getAdditionaluserinfo(loadedUser.getUserId()).getUserInfoId());
        aditionaluserinfo.setUserId(loadedUser.getUserId());
        aditionaluserinfo.setUserAge(age);
        aditionaluserinfo.setUserSex(sex);
        aditionaluserinfo.setUserNationality(nationality);

        aditionalUsersInfoEntityFacade.edit(aditionaluserinfo);
        session.setAttribute("additionuserinfo",aditionaluserinfo);

        forward("/profile.jsp");
    }
}
