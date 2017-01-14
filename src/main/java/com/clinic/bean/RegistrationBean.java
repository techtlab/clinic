package com.clinic.bean;

import com.clinic.service.UserService;
import com.clinic.service.impl.UserServiceImpl;
import com.clinic.domain.User;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "registrationBean")
@SessionScoped
public class RegistrationBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private UserService userService = new UserServiceImpl();

    private User user = new User();

    private static final Logger logger = Logger.getLogger(RegistrationBean.class);

    /*
    * REGISTRATION. ADD USER
    * */

    public String registration() {
        try {
            userService.addNewUser(user.getLogin(), user.getPassword(), user.getRole(),
                    user.getName(), user.getPhone(), user.getAddress());
            sessionBean.setCurrentUser(user);
        } catch (Exception e) {
            logger.info("registration " + e.getMessage());
            return "fail";
        }
        user = new User();
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
