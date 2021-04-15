package com.example.testbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String bmi = getIntent().getStringExtra("BMI");
        int height = getIntent().getIntExtra("height",0);
        TextView showbmi = findViewById(R.id.secondpage);
        showbmi.setText(String.valueOf(height));

    }
}