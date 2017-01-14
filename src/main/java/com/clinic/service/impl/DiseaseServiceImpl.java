package com.clinic.service.impl;

import com.clinic.config.MyBatisUtil;
import com.clinic.domain.User;
import com.clinic.mapper.DiseaseMapper;
import com.clinic.domain.Disease;
import com.clinic.service.DiseaseService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DiseaseServiceImpl implements DiseaseService {

    private SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
    private DiseaseMapper diseaseMapper = sqlSession.getMapper(DiseaseMapper.class);


    public Disease getDiseaseById(int id) {
        return diseaseMapper.getDiseaseById(id);
    }

    public void updateDisease(String name, String description, int cured, int id) {
        diseaseMapper.updateDisease(name, description, cured, id);
        sqlSession.commit();
    }

    public void deleteDisease(int id) {
        diseaseMapper.deleteDisease(id);
        sqlSession.commit();
    }

    public void addDisease(String name, String description, int cured, User user) {
        diseaseMapper.addDisease(name, description, cured, user.getId());
        sqlSession.commit();
    }

    public List<Disease> getDiseaseListByUser(User user) {
        return diseaseMapper.getDiseaseListByUserId(user.getId());
    }
}
