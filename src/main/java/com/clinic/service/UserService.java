package com.clinic.service;

import com.clinic.domain.User;

import java.util.List;

public interface UserService {

    User getUserById(int id);
    List<User> getUsersByRole(byte role);
    User getUserByLoginAndPassword(String login, String password);
    User getUserByLogin(String login);
    void updateUserInfoByLogin(String login, String password, byte role, String name, String phone, String address);
    void addNewUser(String login, String password, byte role, String name, String phone, String address);
    void deleteUser(String login);
}
