package com.clinic.dao.impl;

import com.clinic.config.MyBatisUtil;
import com.clinic.dao.DiseaseDAO;
import com.clinic.mapper.DiseaseMapper;
import com.clinic.model.Disease;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

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

    public static void addSeance(Date date, String description, Disease disease) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            diseaseMapper.addSeance(date, description, disease.getId());
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    /*public static List<Seance> getSeanceListByDiseaseId(Disease disease) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);
            return diseaseMapper.getSeanceListByDiseaseId(disease.getId());
        } finally {
            sqlSession.close();
        }
    }*/
}
