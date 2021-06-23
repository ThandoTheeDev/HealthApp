package com.example.app7311task3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends Activity {

    private Button logout;
    private Button bmicalc;
    private Button workout;
    private Button healthy;
    private Button counter;
    private Button timer;
    private Button camera;
    private Button profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        //
        logout = findViewById(R.id.logout);
        bmicalc = findViewById(R.id.bmicalc);
        workout = findViewById(R.id.workout);
        healthy = findViewById(R.id.healthy);
        counter = findViewById(R.id.counter);
        timer = findViewById(R.id.timer);
        camera = findViewById(R.id.camera);
        profile = findViewById(R.id.profile);
        //
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Dashboard.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //
        bmicalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, BMI.class);
                startActivity(intent);
            }
        });
        //
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Workouts.class);
                startActivity(intent);
            }
        });
        //
        healthy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, HealthyHabits.class);
                startActivity(intent);
            }
        });
        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, StepCounter.class);
                startActivity(intent);
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Timer.class);
                startActivity(intent);
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Camera.class);
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Profile.class);
                startActivity(intent);
            }
        });
    }

}
