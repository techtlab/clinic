package com.clinic.bean;

import com.clinic.model.Disease;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "diseaseBean")
@SessionScoped
public class DiseaseBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private List<Disease> diseases = new ArrayList<>();

    private Disease selectedDisease = new Disease();

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public Disease getSelectedDisease() {
        return selectedDisease;
    }

    public void setSelectedDisease(Disease selectedDisease) {
        this.selectedDisease = selectedDisease;
    }

    public String showSelectedDisease() {
        sessionBean.setSelectedDisease(selectedDisease);
        return "success";
    }

    @PostConstruct
    public void init() {
        /* TODO: get diseases by role */
//        users = userDAO.getUserByRole(Byte.valueOf("0"));

        Disease disease = new Disease();
        disease.setName("ОРВИ");
        disease.setDescription("Кашель");
        diseases.add(disease);
        diseases.add(disease);
        diseases.add(disease);
        diseases.add(disease);
        diseases.add(disease);
        diseases.add(disease);
        diseases.add(disease);
        diseases.add(disease);
    }
}
