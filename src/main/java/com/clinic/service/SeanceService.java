package com.clinic.service;

import com.clinic.domain.Disease;
import com.clinic.domain.Seance;

import java.util.Date;
import java.util.List;

public interface SeanceService {

    Seance getSeanceById(int id);
    void updateSeance(Date date, String description, int id);
    void deleteSeance(int id);
    void addSeance(Date date, String description, Disease disease);
    List<Seance> getSeanceListByDisease(Disease disease);
}
