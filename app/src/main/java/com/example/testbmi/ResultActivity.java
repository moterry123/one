package com.example.testbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

//        String bmi = getIntent().getStringExtra("BMI");
//        int height = getIntent().getIntExtra("height",0);
        Bundle bundle = getIntent().getExtras();
        String bmi = bundle.getString("BMI");
        int height = bundle.getInt("height");

        TextView showbmi = findViewById(R.id.secondpage);
        showbmi.setText(String.valueOf(height));

    }

    public void abc(View view) {
        finish();
    }
}