package com.clinic.dao.impl;

import com.clinic.config.MyBatisUtil;
import com.clinic.dao.SeanceDAO;
import com.clinic.mapper.SeanceMapper;
import com.clinic.model.Seance;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class SeanceDAOImpl implements SeanceDAO {

    public static Seance getSeanceById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SeanceMapper seanceMapper = sqlSession.getMapper(SeanceMapper.class);
            return seanceMapper.getSeanceById(id);
        } finally {
            sqlSession.close();
        }
    }

    public static void addSeance(Date date, String description, int diseaseId) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SeanceMapper seanceMapper = sqlSession.getMapper(SeanceMapper.class);
            seanceMapper.addSeance(date, description, diseaseId);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public static void updateSeance(Date date, String description, int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SeanceMapper seanceMapper = sqlSession.getMapper(SeanceMapper.class);
            seanceMapper.updateSeance(date, description, id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public static void deleteSeance(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SeanceMapper seanceMapper = sqlSession.getMapper(SeanceMapper.class);
            seanceMapper.deleteSeance(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public static List<Seance> getSeanceListByDiseaseId(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SeanceMapper seanceMapper = sqlSession.getMapper(SeanceMapper.class);
            return seanceMapper.getSeanceListByDiseaseId(id);
        } finally {
            sqlSession.close();
        }
    }
}
