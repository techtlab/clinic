package com.clinic.bean;

import com.clinic.dao.SeanceDAO;
import com.clinic.dao.impl.SeanceDAOImpl;
import com.clinic.domain.Seance;

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

    private SeanceDAO seanceDAO = new SeanceDAOImpl();

    private List<Seance> seances = new ArrayList<>();
    private Seance selectedSeance = new Seance();


    public String showSelectedSeance() {
        sessionBean.setSelectedSeance(selectedSeance);
        return "success";
    }

    @PostConstruct
    public void init() {
        seances = seanceDAO.getSeanceListByDisease(sessionBean.getSelectedDisease());
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
