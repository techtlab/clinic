package com.clinic.domain;

import java.util.ArrayList;
import java.util.List;

public class Disease {

    private int id;

    private String name;
    private String description;
    private int cured;

    private List<Seance> seances = new ArrayList<Seance>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCured() {
        return cured;
    }

    public void setCured(int cured) {
        this.cured = cured;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }
}
