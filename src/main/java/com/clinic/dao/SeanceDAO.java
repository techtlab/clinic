package com.clinic.dao;

import com.clinic.domain.Disease;
import com.clinic.domain.Seance;

import java.util.Date;
import java.util.List;

public interface SeanceDAO {

    public Seance getSeanceById(int id);
    public void updateSeance(Date date, String description, int id);
    public void deleteSeance(int id);
    public void addSeance(Date date, String description, Disease disease);
    public List<Seance> getSeanceListByDisease(Disease disease);
}
