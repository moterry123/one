package com.example.testbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        double bmi = Double.parseDouble(bmi_value());
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


 //           showbmi.setText(String.valueOf(bmi)+txt);
              showbmi.setText(String.valueOf(bmi)+txt);

        }

    private String bmi_value() {
        if(height.getText().toString().isEmpty() || weight.getText().toString().isEmpty()) {
            showbmi.setText("請輸入身高或體重的數值");
            return "0.0";
        } else {
            double h = Double.parseDouble(height.getText().toString());
            double w = Double.parseDouble(weight.getText().toString());
            double bmi = w / ((h / 100.0) * (h / 100.0));
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            return decimalFormat.format(bmi);
        }
    }

    public void showToast(View view) {
        String bmi = bmi_value();
        Toast.makeText(this, bmi,Toast.LENGTH_LONG).show();
    }
}