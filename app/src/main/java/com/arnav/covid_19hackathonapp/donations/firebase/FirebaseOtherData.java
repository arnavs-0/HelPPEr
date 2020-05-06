package com.arnav.covid_19hackathonapp.donations.firebase;

public class FirebaseOtherData {
    String address, apartment, city, state, zipcode, amount, comments, what;
    //add data to database
    public FirebaseOtherData(String address, String apartment, String city, String state, String zipcode, String amount, String comments, String what) {
        this.address = address;
        this.apartment = apartment;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
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
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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
