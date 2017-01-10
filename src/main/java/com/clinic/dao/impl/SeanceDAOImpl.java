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

    private SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
    private SeanceMapper seanceMapper = sqlSession.getMapper(SeanceMapper.class);


    public Seance getSeanceById(int id) {
        return seanceMapper.getSeanceById(id);
    }

    public void updateSeance(Date date, String description, int id) {
        seanceMapper.updateSeance(date, description, id);
        sqlSession.commit();
    }

    public void deleteSeance(int id) {
        seanceMapper.deleteSeance(id);
        sqlSession.commit();
    }

    public void addSeance(Date date, String description, Disease disease) {
        seanceMapper.addSeance(date, description, disease.getId());
        sqlSession.commit();
    }

    public List<Seance> getSeanceListByDisease(Disease disease) {
        return seanceMapper.getSeanceListByDiseaseId(disease.getId());
    }
}
