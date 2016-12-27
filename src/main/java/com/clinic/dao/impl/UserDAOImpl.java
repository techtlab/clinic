package com.clinic.dao.impl;

import com.clinic.config.MyBatisUtil;
import com.clinic.mapper.UserMapper;
import com.clinic.model.User;
import org.apache.ibatis.session.SqlSession;

public class UserDAOImpl {

    public static User getUser(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUser(id);
        } finally {
            sqlSession.close();
        }
    }

    /*public static User getUser(String login, String password) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUser(login, password);
        } finally {
            sqlSession.close();
        }
    }*/
}
