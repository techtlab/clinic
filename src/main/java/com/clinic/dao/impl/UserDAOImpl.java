package com.clinic.dao.impl;

import com.clinic.config.MyBatisUtil;
import com.clinic.mapper.UserMapper;
import com.clinic.model.User;
import org.apache.ibatis.session.SqlSession;

public class UserDAOImpl {

    public static User getUserById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserById(id);
        } finally {
            sqlSession.close();
        }
    }

    public static User getUserByRole(byte role) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserByRole(role);
        } finally {
            sqlSession.close();
        }
    }

    public static User getUserByLoginAndPassword(String login, String password) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserByLoginAndPassword(login, password);
        } finally {
            sqlSession.close();
        }
    }

    public static User getUserByLogin(String login) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserByLogin(login);
        } finally {
            sqlSession.close();
        }
    }

    public static void updateUserInfoByLogin(String login, String password, byte role, String name, String phone, String address) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.updateUserInfoByLogin(login, password, role, name, phone, address);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public static void addNewUser(String login, String password, byte role, String name, String phone, String address) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.addNewUser(login, password, role, name, phone, address);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public static void deleteUser(String login) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(login);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
