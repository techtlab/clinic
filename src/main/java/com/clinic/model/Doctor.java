package com.clinic.model;

public class Doctor {

    private int id;
    private Specialization specialization;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
