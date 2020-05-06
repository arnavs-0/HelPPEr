package com.arnav.covid_19hackathonapp.requests.firebase;

public class HospitalRequestData {
    String address, suite, city, state, hospital, amount, comments, what;
    //info to put in database
    public HospitalRequestData(String address, String suite, String city, String state, String hospital, String amount, String comments, String what) {
        this.address = address;
        this.suite = suite;
        this.state = state;
        this.city = city;
        this.hospital = hospital;
        this.amount = amount;
        this.comments = comments;
        this.what = what;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApartment() {
        return suite;
    }

    public void setApartment(String apartment) {
        this.suite = apartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }
}
