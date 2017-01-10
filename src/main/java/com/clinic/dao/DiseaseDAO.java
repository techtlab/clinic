package com.clinic.dao;

import com.clinic.domain.Disease;
import com.clinic.domain.Seance;

import java.util.Date;
import java.util.List;

public interface DiseaseDAO {

    public Disease getDiseaseById(int id);
    public void updateDisease(String name, String description, int cured, int id);
    public void deleteDisease(int id);
    public void addSeance(Date date, String description, Disease disease);
    public List<Seance> getSeanceListByDisease(Disease disease);

}
