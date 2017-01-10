package com.clinic.dao.impl;

import com.clinic.config.MyBatisUtil;
import com.clinic.dao.UserDAO;
import com.clinic.mapper.UserMapper;
import com.clinic.domain.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    private SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
    private UserMapper userMapper = sqlSession.getMapper(UserMapper.class);


    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public List<User> getUsersByRole(byte role) {
        return userMapper.getUsersByRole(role);
    }

    public User getUserByLoginAndPassword(String login, String password) {
        return userMapper.getUserByLoginAndPassword(login, password);
    }

    public User getUserByLogin(String login) {
        return userMapper.getUserByLogin(login);
    }

    public void updateUserInfoByLogin(String login, String password, byte role, String name, String phone, String address) {
        userMapper.updateUserInfoByLogin(login, password, role, name, phone, address);
        sqlSession.commit();
    }

    public void addNewUser(String login, String password, byte role, String name, String phone, String address) {
        userMapper.addNewUser(login, password, role, name, phone, address);
        sqlSession.commit();
    }

    public void deleteUser(String login) {
        userMapper.deleteUser(login);
        sqlSession.commit();
    }
}
