package com.arnav.covid_19hackathonapp.donations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arnav.covid_19hackathonapp.R;
import com.arnav.covid_19hackathonapp.donations.forms.FacemaskDonation;
import com.arnav.covid_19hackathonapp.donations.forms.ShieldDonation;

public class OptionsDonate extends AppCompatActivity {
    Button facemask;
    Button shield;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_donate);

        facemask = findViewById(R.id.mask_form);
        shield = findViewById(R.id.shield_forms);

        facemask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FacemaskDonation.class);
                startActivity(intent);
            }
        });

        shield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShieldDonation.class);
                startActivity(intent);
            }
        });
    }
}
