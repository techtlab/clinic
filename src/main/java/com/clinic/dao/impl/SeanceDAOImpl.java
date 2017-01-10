package com.clinic.dao.impl;

import com.clinic.config.MyBatisUtil;
import com.clinic.dao.SeanceDAO;
import com.clinic.domain.Disease;
import com.clinic.mapper.SeanceMapper;
import com.clinic.domain.Seance;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class SeanceDAOImpl implements SeanceDAO {

    public Seance getSeanceById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SeanceMapper seanceMapper = sqlSession.getMapper(SeanceMapper.class);
            return seanceMapper.getSeanceById(id);
        } finally {
            sqlSession.close();
        }
    }

    public void updateSeance(Date date, String description, int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SeanceMapper seanceMapper = sqlSession.getMapper(SeanceMapper.class);
            seanceMapper.updateSeance(date, description, id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteSeance(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SeanceMapper seanceMapper = sqlSession.getMapper(SeanceMapper.class);
            seanceMapper.deleteSeance(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void addSeance(Date date, String description, Disease disease) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SeanceMapper seanceMapper = sqlSession.getMapper(SeanceMapper.class);
            seanceMapper.addSeance(date, description, disease.getId());
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public List<Seance> getSeanceListByDisease(Disease disease) {
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
        try {
            SeanceMapper seanceMapper = sqlSession.getMapper(SeanceMapper.class);
            return seanceMapper.getSeanceListByDiseaseId(disease.getId());
        } finally {
            sqlSession.close();
        }
    }
}
