package com.arnav.covid_19hackathonapp.create;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arnav.covid_19hackathonapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class OptionsCreate extends AppCompatActivity {
    Button facemask, shield, other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_create);

        facemask = findViewById(R.id.create_mask);
        shield = findViewById(R.id.create_shield);
        other = findViewById(R.id.create_other);
        //move to different actvities based what button is clicked
        facemask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FacemaskCreate.class);
                startActivity(intent);
            }
        });

        shield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShieldCreate.class);
                startActivity(intent);
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OtherCreate.class);
                startActivity(intent);
            }
        });
    }
}
