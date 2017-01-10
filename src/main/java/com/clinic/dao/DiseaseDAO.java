package com.clinic.dao;

import com.clinic.domain.Disease;
import com.clinic.domain.User;

import java.util.List;

public interface DiseaseDAO {

    public Disease getDiseaseById(int id);
    public void updateDisease(String name, String description, int cured, int id);
    public void deleteDisease(int id);
    public void addDisease(String name, String description, int cured, User user);
    public List<Disease> getDiseaseListByUser(User user);
}
