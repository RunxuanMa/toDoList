package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.util.DateUtil;

public class ButtonClickActivity extends AppCompatActivity {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);

        tv_result = findViewById(R.id.tv_result);

        Button btn_click_single= findViewById(R.id.btn_click_single);

        btn_click_single.setOnClickListener(new MyViewOnClickListListener(tv_result));

    }
    static class MyViewOnClickListListener implements View.OnClickListener{

        private final TextView tv_result;
        private MyViewOnClickListListener(TextView tv_result){
            this.tv_result=tv_result;
        }

        @Override
        public void onClick(View view) {
            String desc=String.format("%s 您点击了按钮: %s", DateUtil.getNowTime(),((Button)view).getText());
            tv_result.setText(desc);
        }
    }
}