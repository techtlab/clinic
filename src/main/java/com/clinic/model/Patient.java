package com.clinic.model;

import java.util.Calendar;

public class Patient extends User {

    private Calendar birthday;
    private Address address;


    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
