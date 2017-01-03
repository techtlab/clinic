package com.clinic.bean;

import com.clinic.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "registrationBean")
@SessionScoped
public class RegistrationBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    User user = new User();

    public String registration() {
        return "success";
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
