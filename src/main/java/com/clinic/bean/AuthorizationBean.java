package com.clinic.bean;

import com.clinic.dao.UserDAO;
import com.clinic.dao.impl.UserDAOImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "authorizationBean")
@SessionScoped
public class AuthorizationBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private String login;
    private String password;

    private UserDAO userDAO = new UserDAOImpl();


    /*
    * AUTHORIZATION
    * Get user by login, password.
    * Generate exception.
    * */

    public String authorization() {
        try {
            sessionBean.setCurrentUser(userDAO.getUserByLoginAndPassword(login, password));
        } catch (Exception e) {
            /* TODO: generate exception */
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
