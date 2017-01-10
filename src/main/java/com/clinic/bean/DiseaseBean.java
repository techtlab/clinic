package com.clinic.bean;

import com.clinic.dao.DiseaseDAO;
import com.clinic.dao.impl.DiseaseDAOImpl;
import com.clinic.domain.Disease;

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

    private DiseaseDAO diseaseDAO = new DiseaseDAOImpl();

    private List<Disease> diseases = new ArrayList<>();
    private Disease selectedDisease = new Disease();


    public String showSelectedDisease() {
        sessionBean.setSelectedDisease(selectedDisease);
        return "success";
    }

    @PostConstruct
    public void init() {
        diseases = diseaseDAO.getDiseaseListByUser(sessionBean.getSelectedUser());
    }

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
}
