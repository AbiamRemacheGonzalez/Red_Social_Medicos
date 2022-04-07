package com.example.red_social_medicos.Model;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class EmailDatabaseEntity {
    private String emailUser;
    private String emailDomain;

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getEmailDomain() {
        return emailDomain;
    }

    public void setEmailDomain(String emailDomain) {
        this.emailDomain = emailDomain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailDatabaseEntity that = (EmailDatabaseEntity) o;
        return Objects.equals(emailUser, that.emailUser) && Objects.equals(emailDomain, that.emailDomain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailUser, emailDomain);
    }

    @Override
    public String toString() {
        return emailUser + '@'+emailDomain;
    }

    public static EmailDatabaseEntity getEmailByString(String userEmail){
        EmailDatabaseEntity userMail = new EmailDatabaseEntity();
        if(userEmail.contains("@")){
            userMail.setEmailUser(userEmail.substring(0,userEmail.indexOf("@")));
            userMail.setEmailDomain(userEmail.substring(userEmail.indexOf("@")+1));
        }
        return userMail;
    }
}

