package com.example.fileread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_main=(ListView) findViewById(R.id.lv_main);

        //准备集合数据
        String []data={"A","B","C","D","E","F","G","H","I","J","K","L"};
        //准备arrayAdapter对象
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,R.layout.item_array_adapter,data);

        //设置Adapter显示列表
        lv_main.setAdapter(adapter);

    }
}