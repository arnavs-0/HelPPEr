package com.arnav.covid_19hackathonapp.requests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arnav.covid_19hackathonapp.R;
import com.arnav.covid_19hackathonapp.requests.forms.FirstRespondersRequest;
import com.arnav.covid_19hackathonapp.requests.forms.HospitalRequest;
import com.arnav.covid_19hackathonapp.requests.forms.OtherRequest;

public class OptionsRequest extends AppCompatActivity {
    Button hospital, first, other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_request);

        hospital = findViewById(R.id.hospital_form);
        first = findViewById(R.id.first_responders_forms);
        other = findViewById(R.id.other_request_s);

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HospitalRequest.class);
                startActivity(intent);
            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FirstRespondersRequest.class);
                startActivity(intent);
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OtherRequest.class);
                startActivity(intent);
            }
        });
    }
}
