package com.example.todolist.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;

import com.example.todolist.Bean.ItemBean;

import java.util.List;

public class ListViewAdapterForTheSecondLayer extends RecyclerViewBaseAdapter{



    public ListViewAdapterForTheSecondLayer(List<ItemBean>mData){
        super(mData);

    }

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view=View.inflate(parent.getContext(),R.layout.item_list_view,null);
        return view;
    }

//    @NonNull
//    @Override
//    /**
//     *
//     *这个方法用于创建View
//     *
//     */
//    public ListViewAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View inflate = View.inflate(parent.getContext(), R.layout.item_list_view, null);
//
//        return new InnerHolder(inflate);
//    }

//    /**
//     * 用于绑定holder，一般用来设置数据
//     * @param holder
//     * @param position
//     */
//
//    @Override
//    public void onBindViewHolder(@NonNull ListViewAdapter.InnerHolder holder, int position) {
//
//        holder.setData(mData.get(position));
//
//
//    }

//    /**
//     * 返回条目的个数
//     * @return
//     */
//    @Override
//    public int getItemCount() {
//        if (mData!=null){
//            return mData.size();
//        }
//        return 0;
//    }


}
