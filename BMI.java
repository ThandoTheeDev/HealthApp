package com.example.app7311task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {

    private Button Calculate;
    private EditText Weight,Height;
    private TextView Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);
        //
        Calculate = findViewById(R.id.btCalc);
        Weight = findViewById(R.id.etHeight);
        Height = findViewById(R.id.etHeight);
        Answer = findViewById(R.id.tvAnswer);
        //
        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getW = Weight.getText().toString();
                String getH = Height.getText().toString();

                float W = Float.parseFloat(getW);
                float H = Float.parseFloat(getH);

                float newH = H/100;
                float bmi = W / (newH*newH);

                if (bmi < 18.5)
                {
                    Answer.setText("Under Weight!");
                }
                else if (bmi >= 18.5 && bmi <25)
                {
                    Answer.setText("Normal!");
                }
                else
                {
                    Answer.setText("Obese!");
                }
            }
        });

    }
}