package com.clinic.service;

import com.clinic.domain.Disease;
import com.clinic.domain.User;

import java.util.List;

public interface DiseaseService {

    Disease getDiseaseById(int id);
    void updateDisease(String name, String description, int cured, int id);
    void deleteDisease(int id);
    void addDisease(String name, String description, int cured, User user);
    List<Disease> getDiseaseListByUser(User user);
}
