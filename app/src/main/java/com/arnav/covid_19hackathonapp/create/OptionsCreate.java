package com.arnav.covid_19hackathonapp.create;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arnav.covid_19hackathonapp.R;

public class OptionsCreate extends AppCompatActivity {
    Button facemask, shield, other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_create);

        facemask = findViewById(R.id.create_mask);
        shield = findViewById(R.id.create_shield);
        other = findViewById(R.id.create_other);

        facemask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Uri uri = Uri.parse("https://www.chop.edu/how-make-homemade-diy-face-mask");
                Intent intent = new Intent(getApplicationContext(), FacemaskCreate.class);
                startActivity(intent);
            }
        });

        shield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Uri uri = Uri.parse("https://specs.engin.umich.edu/um-face-shield/");
                Intent intent = new Intent(getApplicationContext(), ShieldCreate.class);
                startActivity(intent);
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Uri uri = Uri.parse("https://enable.hp.com/us-en-3dprint-COVID-19-containment-applications");
                Intent intent = new Intent(getApplicationContext(), OtherCreate.class);
                startActivity(intent);
            }
        });
    }
}
