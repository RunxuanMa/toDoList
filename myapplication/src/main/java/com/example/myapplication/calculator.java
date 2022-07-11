package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.util.cal;

public class calculator extends AppCompatActivity {
    private TextView cal_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        cal_content=findViewById(R.id.cal_content);

        Button cal_0 = findViewById(R.id.cal_0);
        Button cal_1 = findViewById(R.id.cal_1);
        Button cal_2 = findViewById(R.id.cal_2);
        Button cal_3 = findViewById(R.id.cal_3);
        Button cal_4 = findViewById(R.id.cal_4);
        Button cal_5 = findViewById(R.id.cal_5);
        Button cal_6 = findViewById(R.id.cal_6);
        Button cal_7 = findViewById(R.id.cal_7);
        Button cal_8 = findViewById(R.id.cal_8);
        Button cal_9 = findViewById(R.id.cal_9);
        Button cal_AC = findViewById(R.id.cal_AC);
        Button cal_add = findViewById(R.id.cal_add);
        Button cal_div= findViewById(R.id.cal_div);
        Button cal_equal = findViewById(R.id.cal_equal);
        Button cal_mul = findViewById(R.id.cal_mul);
        Button cal_sub = findViewById(R.id.cal_sub);

        cal_0.setOnClickListener(v -> cal_content.append("0"));
        cal_1.setOnClickListener(v -> cal_content.append("1"));
        cal_2.setOnClickListener(v -> cal_content.append("2"));
        cal_3.setOnClickListener(v -> cal_content.append("3"));
        cal_4.setOnClickListener(v -> cal_content.append("4"));
        cal_5.setOnClickListener(v -> cal_content.append("5"));
        cal_6.setOnClickListener(v -> cal_content.append("6"));
        cal_7.setOnClickListener(v -> cal_content.append("7"));
        cal_8.setOnClickListener(v -> cal_content.append("8"));
        cal_9.setOnClickListener(v -> cal_content.append("9"));
        cal_AC.setOnClickListener(v -> cal_content.setText(""));
        cal_add.setOnClickListener(v -> cal_content.append("+"));
        cal_div.setOnClickListener(v -> cal_content.append("÷"));
        cal_mul.setOnClickListener(v -> cal_content.append("*"));
        cal_sub.setOnClickListener(v -> cal_content.append("-"));
        cal_equal.setOnClickListener(v -> {
            CharSequence text = cal_content.getText();

            Integer caltext = cal.Cal(text);
            String s= Integer.toString(caltext);

            cal_content.append("=");
            cal_content.append(s);
        });


    }
}