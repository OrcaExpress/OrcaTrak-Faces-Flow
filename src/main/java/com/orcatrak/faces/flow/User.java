package com.orcatrak.faces.flow;

import java.io.Serializable;
import java.util.Map;
import java.util.Random;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowHandler;
import javax.faces.flow.FlowScoped;
import javax.faces.lifecycle.ClientWindow;
import javax.inject.Named;

@Named
@FlowScoped(value = "user")
public class User implements Serializable {

    String firstName;
    String lastName;
    String email;
    String password;
    FacesContext facesContext = FacesContext.getCurrentInstance();
    Application application = facesContext.getApplication();
    FlowHandler flowHandler = application.getFlowHandler();
    Map<Object, Object> flowMap = flowHandler.getCurrentFlowScope(); //get access to the map that backs #{flowScope}
    ExternalContext externalContext = facesContext.getExternalContext();
    ClientWindow clientWindow = externalContext.getClientWindow();

//    public User() {
//        if (clientWindow != null) {
//            System.out.println("client window id: " + clientWindow.getId());
//        } else {
//            System.out.println("client window cannot be deteremined!");
//        }
//    }
//
//    public User(String firstName, String lastName, String email, String password) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
