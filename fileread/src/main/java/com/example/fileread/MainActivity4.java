package com.example.fileread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {

    private Button btn_add;private Button btn_flow;
    private Button btn_grid;private Button btn_list;
    private Button btn_delete;
    private RecyclerView recyclerView;

    private ArrayList<String>datas;
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();

        //recyclerView 适配器
        adapter=new MyRecyclerViewAdapter(MainActivity4.this,datas);
        recyclerView.setAdapter(adapter);

    }

    private void initData(){
        datas=new ArrayList<>();
        for (int i=0;i<100;i++){
            datas.add("content"+i);
        }

    }

    private void initView(){

        setContentView(R.layout.activity_main4);

        btn_add=(Button) findViewById(R.id.btn_add);
        btn_grid= (Button)findViewById(R.id.btn_grid);
        btn_delete=(Button) findViewById(R.id.btn_delete);
        btn_flow= (Button)findViewById(R.id.btn_flow);
        btn_list= (Button)findViewById(R.id.btn_list);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);



        btn_add.setOnClickListener(this);
        btn_grid.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_flow.setOnClickListener(this);
        btn_list.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_add:
                break;
            case R.id.btn_delete:
                break;
            case R.id.btn_grid:
                break;
            case R.id.btn_list:
                break;
            case R.id.btn_flow:
                break;
        }
    }

}