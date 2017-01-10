package com.clinic.bean;

import com.clinic.domain.Disease;
import com.clinic.domain.Seance;
import com.clinic.domain.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {

    private User currentUser = new User();

    private User selectedUser = new User();

    private Disease selectedDisease = new Disease();

    private Seance selectedSeance = new Seance();

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public Disease getSelectedDisease() {
        return selectedDisease;
    }

    public void setSelectedDisease(Disease selectedDisease) {
        this.selectedDisease = selectedDisease;
    }

    public Seance getSelectedSeance() {
        return selectedSeance;
    }

    public void setSelectedSeance(Seance selectedSeance) {
        this.selectedSeance = selectedSeance;
    }
}
