package com.clinic.bean;

import com.clinic.service.UserService;
import com.clinic.service.impl.UserServiceImpl;

import org.apache.log4j.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "authorizationBean")
@SessionScoped
public class AuthorizationBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private UserService userService = new UserServiceImpl();

    private String login;
    private String password;

    private static final Logger logger = Logger.getLogger(AuthorizationBean.class);

    /*
    * AUTHORIZATION. GET USER BY LOGIN-PASSWORD
    * */

    public String authorization() {
        try {
            sessionBean.setCurrentUser(userService.getUserByLoginAndPassword(login, password));
        } catch (Exception e) {
            logger.info("authorization " + e.getMessage());
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
