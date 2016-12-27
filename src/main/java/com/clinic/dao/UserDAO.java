package com.clinic.dao;

import com.clinic.config.MyBatisUtil;
import com.clinic.mapper.UserMapper;
import com.clinic.model.User;
import org.apache.ibatis.session.SqlSession;

public class UserDAO {
    public static User getUserById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.getUserById(id);
        } finally {
            sqlSession.close();
        }
    }
}
