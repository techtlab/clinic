package com.clinic.dao.impl;

import com.clinic.config.MyBatisUtil;
import com.clinic.dao.DiseaseDAO;
import com.clinic.mapper.DiseaseMapper;
import com.clinic.model.Disease;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/* TODO: Refactoring */
/* TODO: Add overloading */
/* TODO: Add search by criteria */
public class DiseaseDAOImpl implements DiseaseDAO {

    public static Disease getDiseaseById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            return diseaseMapper.getDiseaseById(id);
        } finally {
            sqlSession.close();
        }
    }

    public static void updateDisease(String name, String description, int cured, int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            diseaseMapper.updateDisease(name, description, cured, id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public static void deleteDisease(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            diseaseMapper.deleteDisease(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public static void addDisease(String name, String description, int cured, int userId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            diseaseMapper.addDisease(name, description, cured, userId);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public static List<Disease> getDiseaseListByUserId(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            return diseaseMapper.getDiseaseListByUserId(id);
        } finally {
            sqlSession.close();
        }
    }
}
