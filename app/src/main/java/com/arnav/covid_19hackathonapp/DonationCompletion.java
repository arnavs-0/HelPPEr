package com.arnav.covid_19hackathonapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DonationCompletion extends AppCompatActivity {
    //final screen, once request come in emails will be sent through firebase messaging service
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_completion);
    }
}
