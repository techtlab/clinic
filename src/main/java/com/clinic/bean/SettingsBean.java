package com.clinic.bean;

import com.clinic.service.UserService;
import com.clinic.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "settingsBean")
@SessionScoped
public class SettingsBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private UserService userService = new UserServiceImpl();

    private static final Logger logger = Logger.getLogger(SettingsBean.class);

    /*
    * UPDATE USER. UPDATE USER INFO BY LOGIN
    * */
    public String updateUser() {
        try {
            userService.updateUserInfoByLogin(sessionBean.getCurrentUser().getLogin(), sessionBean.getCurrentUser().getPassword(),
                    sessionBean.getCurrentUser().getRole(), sessionBean.getCurrentUser().getName(),
                    sessionBean.getCurrentUser().getPhone(), sessionBean.getCurrentUser().getAddress());
        } catch (Exception e) {
            logger.info("updateUser " + e.getMessage());
            return "fail";
        }
        return "success";
    }

    /*
    * DELETE USER
    * */
    public String deleteUser() {
        try {
            userService.deleteUser(sessionBean.getCurrentUser().getLogin());
        } catch (Exception e) {
            logger.info("deleteUser " + e.getMessage());
            return "fail";
        }
        return "success";
    }



    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
