package com.clinic.dao;

import com.clinic.model.Seance;

import java.util.Date;

public interface SeanceDAO {

    public Seance getSeanceById(int id);
    public void updateSeance(Date date, String description, int id);
    public void deleteSeance(int id);

}
