package com.clinic.bean;

import com.clinic.dao.UserDAO;
import com.clinic.dao.impl.UserDAOImpl;
import com.clinic.domain.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "registrationBean")
@SessionScoped
public class RegistrationBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private User user = new User();

    private UserDAO userDAO = new UserDAOImpl();


    /*
    * REGISTRATION
    * Save user.
    * Generate exception.
    * Generate message.
    * */

    public String registration() {
        try {
            /* TODO: change to addUser(user) */
            userDAO.addNewUser(user.getLogin(), user.getPassword(), user.getRole(),
                    user.getName(), user.getPhone(), user.getAddress());
            sessionBean.setCurrentUser(user);
        } catch (Exception e) {
            /* TODO: generate exception */
            return "fail";
        }
        /* TODO: generate message */
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
