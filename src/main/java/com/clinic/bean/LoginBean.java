package com.clinic.bean;

import com.clinic.dao.impl.UserDAOImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

    private String login;
    private String password;

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;


    public String authorization() {
        try {
//            sessionBean.setCurrentUser(UserDAOImpl.getUser(login, password));
            sessionBean.setCurrentUser(UserDAOImpl.getUser(1));
        } catch (Exception e) {
            System.out.println("### Exception: " + e.getMessage());
            return "fail";
        }
        login = password = "";
        return "success";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

}
