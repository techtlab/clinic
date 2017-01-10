package com.clinic.bean;

import com.clinic.dao.UserDAO;
import com.clinic.dao.impl.UserDAOImpl;
import com.clinic.domain.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private List<User> users = new ArrayList<>();
    private User selectedUser = new User();

    private UserDAO userDAO = new UserDAOImpl();


    public String showSelectedUser() {
        sessionBean.setSelectedUser(selectedUser);
        return "success";
    }

    @PostConstruct
    public void init() {
        byte patient = 0;
        users = userDAO.getUsersByRole(patient);
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
