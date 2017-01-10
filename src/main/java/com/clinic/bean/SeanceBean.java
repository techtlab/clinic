package com.clinic.bean;

import com.clinic.dao.SeanceDAO;
import com.clinic.dao.impl.SeanceDAOImpl;
import com.clinic.domain.Seance;
import org.apache.log4j.Logger;

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

    private static final Logger logger = Logger.getLogger(SeanceBean.class);

    /*
    * SHOW SELECTED SEANCE
    * */

    public String showSelectedSeance() {
        sessionBean.setSelectedSeance(selectedSeance);
        return "success";
    }

    /*
    * GET SEANCE BY SELECTED DISEASE. POST CONSTRUCT
    * */

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
