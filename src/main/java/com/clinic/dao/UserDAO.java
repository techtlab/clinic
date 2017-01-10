package com.clinic.dao;

import com.clinic.domain.Disease;
import com.clinic.domain.User;

import java.util.List;

public interface UserDAO {

    public User getUserById(int id);
    public List<User> getUsersByRole(byte role);
    public User getUserByLoginAndPassword(String login, String password);
    public User getUserByLogin(String login);
    public void updateUserInfoByLogin(String login, String password, byte role, String name, String phone, String address);
    public void addNewUser(String login, String password, byte role, String name, String phone, String address);
    public void deleteUser(String login);
    public void addDisease(String name, String description, int cured, User user);
    public List<Disease> getDiseaseListByUser(User user);

}
