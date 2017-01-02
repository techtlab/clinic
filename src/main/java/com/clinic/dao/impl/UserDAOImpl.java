package com.clinic.dao.impl;

import com.clinic.config.MyBatisUtil;
import com.clinic.dao.UserDAO;
import com.clinic.mapper.UserMapper;
import com.clinic.model.Disease;
import com.clinic.model.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    public User getUserById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserById(id);
        } finally {
            sqlSession.close();
        }
    }

    public User getUserByRole(byte role) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserByRole(role);
        } finally {
            sqlSession.close();
        }
    }

    public User getUserByLoginAndPassword(String login, String password) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserByLoginAndPassword(login, password);
        } finally {
            sqlSession.close();
        }
    }

    public User getUserByLogin(String login) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserByLogin(login);
        } finally {
            sqlSession.close();
        }
    }

    public void updateUserInfoByLogin(String login, String password, byte role, String name, String phone, String address) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.updateUserInfoByLogin(login, password, role, name, phone, address);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void addNewUser(String login, String password, byte role, String name, String phone, String address) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.addNewUser(login, password, role, name, phone, address);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteUser(String login) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(login);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void addDisease(String name, String description, int cured, User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.addDisease(name, description, cured, user.getId());
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public List<Disease> getDiseaseListByUser(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getDiseaseListByUserId(user.getId());
        } finally {
            sqlSession.close();
        }
    }
}
