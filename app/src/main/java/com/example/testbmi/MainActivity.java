package com.example.testbmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
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
    private boolean[] checked;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Start","===start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Stop","===stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Destory","===destory");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Pause","===pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Resume","===resume");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Create","===create");
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.edHeight);
        weight = findViewById(R.id.edWeight);
        showbmi = findViewById(R.id.tvShowBMI);
        ImageView = findViewById(R.id.ivshow);
        checked = new boolean[]{false, false, false, false};
    }

    public void calBMI(View view) {
        double bmi = Double.parseDouble(bmi_value());
        String txt = "";
        if (bmi < 18.5) {
            txt = "體重過輕";
            ImageView.setImageResource(R.drawable.a1);
        } else if (bmi > 25) {
            txt = "體重過重";
            ImageView.setImageResource(R.drawable.a3);
        } else {
            txt = "體重正常";
            ImageView.setImageResource(R.drawable.a2);
        }


        //           showbmi.setText(String.valueOf(bmi)+txt);
        showbmi.setText(String.valueOf(bmi) + txt);

    }

    private String bmi_value() {
        if (height.getText().toString().isEmpty() || weight.getText().toString().isEmpty()) {
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
        Toast toast = Toast.makeText(this, bmi, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
//      Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        toast.show();
    }

    public void show_alterdialog(View view) {
        //       String[] a={"Red","Green","Blue"};

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("你的BMI")
//                .setMessage(bmi_value())
//                .setItems(R.array.color, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        String[] colorArray = getResources().getStringArray(R.array.color);
//                        showbmi.setText(colorArray[which]);
//                    }
//                })
                .setMultiChoiceItems(R.array.color, checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "ABC", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNeutralButton("ABC", null)
                .setIcon(R.drawable.ic_launcher_foreground)
                .show();
    }


    public void twopage(View view) {
        Intent intent = new Intent(this,ResultActivity.class);
//        intent.putExtra("BMI",bmi_value());
//        intent.putExtra("height",180);
         Bundle bundle = new Bundle();
         bundle.putString("BMI",bmi_value());
         bundle.putInt("height",180);
         intent.putExtras(bundle);
         startActivity(intent);
    }
}