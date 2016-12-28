package com.clinic.model;

public class Doctor extends User {

    private Specialization specialization;


    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
