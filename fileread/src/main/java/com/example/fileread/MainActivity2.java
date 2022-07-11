package com.example.fileread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {
    private ListView lv_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv_main=(ListView) findViewById(R.id.lv_main2);

        //准备集合数据
        List<Map<String,Object>>data=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("icon",R.drawable.f1);
        map.put("name","abyss");
        map.put("content","anime");
        data.add(map);
        map=new HashMap<String,Object>();
        map.put("icon",R.drawable.f2);
        map.put("name","shell");
        map.put("content","wife");
        data.add(map);


        //map里面key的数组，用于得到对应的value
        String []from={"icon","name","content"};

        //item布局文件中的子view的id的数组
        int[]to={R.id.iv_item_icon,R.id.item_name,R.id.item_content};

        //准备simple对象

        SimpleAdapter adapter=new SimpleAdapter(this,data,R.layout.item_simple_adapter,
                from,to);

        //设置Adapter显示列表
        lv_main.setAdapter(adapter);


    }
}