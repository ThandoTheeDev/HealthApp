package com.example.app7311task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class Timer extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean running;
    private long pauseoffset;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 100000)
                {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(Timer.this,"Hooray!!!", Toast.LENGTH_SHORT);
                }
            }
        });

    }
    public void startChronometer (View v )
    {
        if (!running )
        {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseoffset);
            chronometer.start();
            running = true;
        }
    }
    public void pauseChronometer (View v )
    {
        if (!running )
        {
            chronometer.stop();
            pauseoffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }
    public void resetChronometer (View v )
    {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseoffset = 0;
    }
}