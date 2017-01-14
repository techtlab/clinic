package com.clinic.bean;

import com.clinic.service.UserService;
import com.clinic.service.impl.UserServiceImpl;
import com.clinic.domain.User;
import org.apache.log4j.Logger;

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

    private UserService userService = new UserServiceImpl();

    private List<User> users = new ArrayList<>();
    private User selectedUser = new User();

    private static final Logger logger = Logger.getLogger(UserBean.class);

    /*
    * SHOW SELECTED USER
    * */
    public String showSelectedUser() {
        sessionBean.setSelectedUser(selectedUser);
        return "success";
    }

    /*
    * GET USERS BY ROLE(0). POST CONSTRUCT
    * */
    @PostConstruct
    public void init() {
        byte patient = 0;
        users = userService.getUsersByRole(patient);
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
