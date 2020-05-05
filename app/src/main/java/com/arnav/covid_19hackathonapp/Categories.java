package com.arnav.covid_19hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arnav.covid_19hackathonapp.create.OptionsCreate;
import com.arnav.covid_19hackathonapp.requests.OptionsRequest;
import com.arnav.covid_19hackathonapp.donations.OptionsDonate;

public class Categories extends AppCompatActivity {
    Button donate, request, create, sites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        //Hooks
        donate = findViewById(R.id.donate_options);
        request = findViewById(R.id.request_options);
        create = findViewById(R.id.create_options);
        sites = findViewById(R.id.donation_sites);

        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OptionsDonate.class);
                startActivity(intent);
            }
        });

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OptionsRequest.class);
                startActivity(intent);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OptionsCreate.class);
                startActivity(intent);
            }
        });
        sites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DonationSitesList.class);
                startActivity(intent);
            }
        });
    }
}
