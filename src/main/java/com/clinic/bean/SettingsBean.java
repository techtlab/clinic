package com.clinic.bean;

import com.clinic.dao.UserDAO;
import com.clinic.dao.impl.UserDAOImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "settingsBean")
@SessionScoped
public class SettingsBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private UserDAO userDAO = new UserDAOImpl();


    /*
    * UPDATE USER
    * Update user.
    * Generate exception.
    * Generate message.
    * */
    public String updateUser() {
        try {
            /* TODO: change to updateUser(user) */
            /* TODO: use id */
            userDAO.updateUserInfoByLogin(sessionBean.getCurrentUser().getLogin(), sessionBean.getCurrentUser().getPassword(),
                    sessionBean.getCurrentUser().getRole(), sessionBean.getCurrentUser().getName(),
                    sessionBean.getCurrentUser().getPhone(), sessionBean.getCurrentUser().getAddress());
        } catch (Exception e) {
            /* TODO: generate exception */
            return "fail";
        }
        /* TODO: generate message */
        return "success";
    }


    /*
    * DELETE USER
    * Delete user.
    * Generate exception.
    * Generate message.
    * */
    public String deleteUser() {
        try {
            /* TODO: change to deleteUser(user) */
            /* TODO: use id */
            userDAO.deleteUser(sessionBean.getCurrentUser().getLogin());
        } catch (Exception e) {
            /* TODO: generate exception */
            return "fail";
        }
        /* TODO: generate message */
        return "success";
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
