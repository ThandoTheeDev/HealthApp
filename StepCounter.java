package com.example.app7311task3;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class StepCounter extends AppCompatActivity implements SensorEventListener {

    private TextView stepcounter;
    private Sensor mStepCounter;
    private SensorManager sensorManager;
    private boolean isCounterSensorPresent;
    int stepCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_counter);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        stepcounter = findViewById(R.id.stepcounter);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) !=null);
        {
            mStepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isCounterSensorPresent = true;
        }
        stepcounter.setText("Sensor not present!");
        isCounterSensorPresent = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null)
        sensorManager.unregisterListener(this,mStepCounter);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null)
        sensorManager.registerListener(this,mStepCounter,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == mStepCounter)
        {
            stepCount = (int) sensorEvent.values[0];
            stepcounter.setText(String.valueOf(stepCount));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}