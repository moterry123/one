package com.example.testbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private TextView showbmi;
    private ImageView ImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.edHeight);
        weight = findViewById(R.id.edWeight);
        showbmi = findViewById(R.id.tvShowBMI);
        ImageView =findViewById(R.id.ivshow);
    }

    public void calBMI(View view) {
        if(height.getText().toString().isEmpty() || weight.getText().toString().isEmpty()) {
            showbmi.setText("請輸入身高或體重的數值");
        } else {
            double h = Double.parseDouble(height.getText().toString());
            double w = Double.parseDouble(weight.getText().toString());
            double bmi = w / ((h/100.0) * (h/100.0));
            String txt = "";
            if(bmi<18.5) {
                txt = "體重過輕";
                ImageView.setImageResource(R.drawable.a1);
            } else if (bmi>25) {
                txt = "體重過重";
                ImageView.setImageResource(R.drawable.a3);
            } else {
                txt = "體重正常";
                ImageView.setImageResource(R.drawable.a2);
            }
            DecimalFormat decimalFormat = new DecimalFormat("#.##");

 //           showbmi.setText(String.valueOf(bmi)+txt);
              showbmi.setText(decimalFormat.format(bmi)+txt);

        }

    }
}