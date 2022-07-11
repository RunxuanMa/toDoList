package com.example.fileread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private ListView lv_main;
    private ArrayList<ShopInfo> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        lv_main=(ListView) findViewById(R.id.lv_main3);

        //准备集合数据
        data = new ArrayList<>();
        data.add(new ShopInfo(R.drawable.f1,"abyss","anime"));
        data.add(new ShopInfo(R.drawable.f2,"shell","wife"));

        //准备BaseAdapter对象
        MyAdapter adapter = new MyAdapter();

        //设置Adapter显示列表

        lv_main.setAdapter(adapter);


    }

    class MyAdapter extends BaseAdapter{


        //返回集合数据的数量
        @Override
        public int getCount() {
            return data.size();
        }

        //返回下标对应的数据对象
        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        /**
         *
         * 返回指定下标所对应的item的 View对象
         *
         * @param position  下标
         * @param convertView
         * @param parent 就是ListView对象
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //加载item的布局，得到View对象
            View view = View.inflate(MainActivity3.this, R.layout.item_simple_adapter, null);


            //根据  position 设置对应的数据
                    // 得到当前行的数据对象

            ShopInfo shopInfo = data.get(position);
                    // 得到子View 对象
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_icon);

            TextView contentTV = (TextView) view.findViewById(R.id.item_content);

            TextView nameTV = (TextView) view.findViewById(R.id.item_name);

                    //设置数据
            imageView.setImageResource(shopInfo.getIcon());
            nameTV.setText(shopInfo.getName());
            contentTV.setText(shopInfo.getContent());

            return view;
        }
    }

}