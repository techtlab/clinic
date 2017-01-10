package com.clinic.dao.impl;

import com.clinic.config.MyBatisUtil;
import com.clinic.dao.DiseaseDAO;
import com.clinic.domain.User;
import com.clinic.mapper.DiseaseMapper;
import com.clinic.domain.Disease;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DiseaseDAOImpl implements DiseaseDAO {

    public Disease getDiseaseById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            return diseaseMapper.getDiseaseById(id);
        } finally {
            sqlSession.close();
        }
    }

    public void updateDisease(String name, String description, int cured, int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            diseaseMapper.updateDisease(name, description, cured, id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteDisease(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            diseaseMapper.deleteDisease(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void addDisease(String name, String description, int cured, User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            diseaseMapper.addDisease(name, description, cured, user.getId());
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public List<Disease> getDiseaseListByUser(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            return diseaseMapper.getDiseaseListByUserId(user.getId());
        } finally {
            sqlSession.close();
        }
    }
}
