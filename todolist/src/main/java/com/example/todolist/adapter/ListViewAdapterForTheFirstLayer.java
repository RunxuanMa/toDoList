package com.example.todolist.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.todolist.Bean.ItemBean;
import com.example.todolist.MainActivity;
import com.example.todolist.R;

import java.util.List;

public class ListViewAdapterForTheFirstLayer extends RecyclerViewBaseAdapter{
    private final List<ItemBean> Data;
    public ListViewAdapterForTheFirstLayer(List<ItemBean> mData) {
        super(mData);
        this.Data=mData;
    }

    @Override
    public View getSubView(ViewGroup parent, int viewType) {
        View view=View.inflate(parent.getContext(), R.layout.firstlayer,null);



//        view.setOnClickListener(l->{
//
//            ItemBean itemBean=null;
//
//            ListViewAdapterForTheSecondLayer listViewAdapterForTheSecondLayer=new ListViewAdapterForTheSecondLayer(Data);
//
//            View SecondView=View.inflate(parent.getContext(), R.layout.item_list_view,null);
//
//
//            if (SecondView==null){
//                Log.e("pa","dd");
//            }
//
//            TextView id=view.findViewById(R.id.listView_ID);
//
//            CharSequence text = id.getText();
//
//            TextView listView_id = SecondView.findViewById(R.id.listView_id);
//            TextView updated = SecondView.findViewById(R.id.listView_updated);
//            TextView status = SecondView.findViewById(R.id.listView_status);
//            TextView created = SecondView.findViewById(R.id.listView_created);
//            TextView content = SecondView.findViewById(R.id.listView_content);
//
//
//            for (ItemBean data:Data){
//                if (String.valueOf(data.getID())==text){
//                    itemBean=data;
//                }
//            }
//
//            listView_id.setText(String.valueOf(itemBean.getID()));
//            content.setText(itemBean.getContent());
//            created.setText((String.valueOf((itemBean.getCreated())/1000)));
//            updated.setText((String.valueOf((itemBean.getUpdated())/1000)));
//            status.setText(itemBean.getStatus());
//
//
//
//        });


        return view;
    }
}
