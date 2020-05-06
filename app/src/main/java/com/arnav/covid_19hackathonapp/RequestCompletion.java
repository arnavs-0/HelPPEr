package com.arnav.covid_19hackathonapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class RequestCompletion extends AppCompatActivity {
    //final page for form request, emails would be sent once donations come in
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_completion);
    }
}
