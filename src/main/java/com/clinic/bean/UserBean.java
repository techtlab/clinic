package com.clinic.bean;

import com.clinic.dao.UserDAO;
import com.clinic.dao.impl.UserDAOImpl;
import com.clinic.model.User;

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

    private UserDAO userDAO = new UserDAOImpl();

    private User selectedUser = new User();


    public String showSelectedUser() {
        sessionBean.setSelectedUser(selectedUser);
        return "success";
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

    @PostConstruct
    public void init() {
        /* TODO: get users by role */
//        users = userDAO.getUserByRole(Byte.valueOf("0"));
        User user = new User();
        user.setName("Иван Иванович Иванов");
        user.setAddress("г.Гродно, ул.Тавлая, д.12");
        user.setPhone("+375(33) 324-67-84");
        User user2 = new User();
        user2.setName("Пётр Иванович Иванов");
        user2.setAddress("г.Гродно, ул.Тавлая, д.12");
        user2.setPhone("+375(33) 324-67-84");
        users.add(user);
        users.add(user2);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
