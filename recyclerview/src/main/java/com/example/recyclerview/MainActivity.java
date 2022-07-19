package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.recyclerview.adapter.GridViewAdapter;
import com.example.recyclerview.adapter.ListViewAdapter;
import com.example.recyclerview.beans.ItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 总结：
 *
 * 1.通过findViewById 找到控件
 * 2.准备数据
 * 3.设置布局管理器 LayoutManager
 * 4.创建适配器 Adapter
 * 5.设置适配器
 *
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView mList;
    private List<ItemBean>mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到控件
        mList=(RecyclerView) this.findViewById(R.id.recycler_view);

        //准备数据
        initData();

        // 这是默认效果
        showList(true,false);

    }

    /**
     *
     * 这个方法用于模拟数据
     *
     */

    private void initData(){

        mData=new ArrayList<>();

        //模拟数据
        for (int i=0;i<20;i++){

            ItemBean data = new ItemBean();
            data.icon= String.valueOf(i);
            data.title="我是第"+i+"个项目";

            mData.add(data);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId=item.getItemId();

        switch (itemId){

            //ListView
            case R.id.list_view_horizontal_reverse:
                showList(false,true);
                break;
            case R.id.list_view_horizontal_stander:
                showList(false,false);
                break;
            case R.id.list_view_vertical_reverse:
                showList(true,true);
                break;
            case R.id.list_view_vertical_stander:
                showList(true,false);
                break;

            case R.id.grid_view_horizontal_reverse:
                showGrid(false,true);
                break;
            case R.id.grid_view_horizontal_stander:
                showGrid(false,false);
                break;
            case R.id.grid_view_vertical_reverse:
                showGrid(true,true);
                break;
            case R.id.grid_view_vertical_stander:
                showGrid(true,false);
                break;


            case R.id.stagger_view_horizontal_reverse:
                break;
            case R.id.stagger_view_horizontal_stander:
                break;
            case R.id.stagger_view_vertical_reverse:
                break;
            case R.id.stagger_view_vertical_stander:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    /**
     *  用于显示ListView 一样的效果
     */
    private void showList(boolean isVertical,boolean isReverse) {

        //RecyclerView设置样式
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);


        //设置布局管理器来控制
        //设置水平or垂直
        //正向or反向

        linearLayoutManager.setOrientation(isVertical? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);

        linearLayoutManager.setReverseLayout(isReverse);

        mList.setLayoutManager(linearLayoutManager);

        //适配器
        ListViewAdapter listViewAdapter = new ListViewAdapter(mData);

        //适配器设置到RecyclerView里面

        mList.setAdapter(listViewAdapter);

    }

    /**
     * 用于显示 GridView
     */
    private void showGrid(boolean isVertical,boolean isReverse){

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        gridLayoutManager.setReverseLayout(isReverse);
        gridLayoutManager.setOrientation(isVertical?GridLayoutManager.VERTICAL : GridLayoutManager.HORIZONTAL);

        mList.setLayoutManager(gridLayoutManager);

        //适配器捏

        GridViewAdapter gridViewAdapter = new GridViewAdapter(mData);

        mList.setAdapter(gridViewAdapter);

    }


}