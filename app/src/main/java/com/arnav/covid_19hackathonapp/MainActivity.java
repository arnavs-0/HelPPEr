package com.arnav.covid_19hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Variables in Use
    Animation topAnim, bottomAnim;
    ImageView logo;
    TextView name, overview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Hide the Top Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animation for the Loading Screen
        Context context;
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation( this, R.anim.bottom_animation);

        //Hooks
        logo = findViewById(R.id.logo);
        name = findViewById(R.id.name);
        overview = findViewById(R.id.overview);

        logo.setAnimation(topAnim);
        name.setAnimation(bottomAnim);
        overview.setAnimation(topAnim);

    }
}
