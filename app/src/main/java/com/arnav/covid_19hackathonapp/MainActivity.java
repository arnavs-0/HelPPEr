package com.arnav.covid_19hackathonapp;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.arnav.covid_19hackathonapp.auth.Login;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //Opening screen lasts for 5 seconds
    private static int SPLASH_SCREEN = 5000;
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
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        logo = findViewById(R.id.logo);
        name = findViewById(R.id.name);
        overview = findViewById(R.id.overview);

        logo.setAnimation(topAnim);
        name.setAnimation(bottomAnim);
        overview.setAnimation(topAnim);

        //Change Screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(logo, "logo_image");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, new Pair<View, String>(logo, "logo_image"));
                startActivity(intent, options.toBundle());
            }
        }, SPLASH_SCREEN);

    }
}
