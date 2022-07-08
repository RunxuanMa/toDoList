package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.util.DateUtil;

public class ButtonLongClickActivity extends AppCompatActivity {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_long_click);

        tv_result = findViewById(R.id.tv_result);

        Button btn_click_single=findViewById(R.id.btn_long_click);

        btn_click_single.setOnLongClickListener(view -> {
            String desc=String.format("%s 您点击了按钮嘿嘿嘿: %s", DateUtil.getNowTime(),((Button)view).getText());
            tv_result.setText(desc);


            return true;
        });

    }

}