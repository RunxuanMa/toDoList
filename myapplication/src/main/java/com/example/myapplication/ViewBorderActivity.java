package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewBorderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_border);
        TextView tv_code = findViewById(R.id.tv_code);

//        //获取布局参数
//        ViewGroup.LayoutParams layoutParams = viewById.getLayoutParams();
//        layoutParams.width=0;
//
//        //修改
//        tv_code.setLayoutParams(layoutParams);


    }
}