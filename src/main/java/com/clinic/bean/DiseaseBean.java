package com.clinic.bean;

import com.clinic.dao.UserDAO;
import com.clinic.dao.impl.UserDAOImpl;
import com.clinic.model.Disease;
import com.clinic.model.User;

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

    private UserDAO userDAO = new UserDAOImpl();

    private List<Disease> diseases = new ArrayList<>();
    private Disease selectedDisease = new Disease();


    public String showSelectedDisease() {
        sessionBean.setSelectedDisease(selectedDisease);
        return "success";
    }

    @PostConstruct
    public void init() {

        User user = userDAO.getUserById(3);
        sessionBean.setSelectedUser(user);

        diseases = userDAO.getDiseaseListByUser(user);
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
