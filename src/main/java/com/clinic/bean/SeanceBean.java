package com.clinic.bean;

import com.clinic.model.Seance;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "seanceBean")
@SessionScoped
public class SeanceBean {

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    private List<Seance> seances = new ArrayList<>();

    private Seance selectedSeance = new Seance();

    @PostConstruct
    public void init() {
        /* TODO: get seances by role */
//        users = userDAO.getUserByRole(Byte.valueOf("0"));

        Seance seance = new Seance();
        seance.setDescription("Осмотр (17.02.2019");

        seances.add(seance);
        seances.add(seance);
        seances.add(seance);
        seances.add(seance);
        seances.add(seance);
        seances.add(seance);
        seances.add(seance);

    }

    public String showSelectedSeance() {
        sessionBean.setSelectedSeance(selectedSeance);
        return "success";
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

    public Seance getSelectedSeance() {
        return selectedSeance;
    }

    public void setSelectedSeance(Seance selectedSeance) {
        this.selectedSeance = selectedSeance;
    }
}
