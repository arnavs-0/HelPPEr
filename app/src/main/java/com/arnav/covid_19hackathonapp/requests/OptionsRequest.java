package com.arnav.covid_19hackathonapp.requests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arnav.covid_19hackathonapp.R;
import com.arnav.covid_19hackathonapp.requests.forms.HospitalRequest;

public class OptionsRequest extends AppCompatActivity {
    Button hospital;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_request);

        hospital = findViewById(R.id.hospital_form);

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HospitalRequest.class);
                startActivity(intent);
            }
        });
    }
}
