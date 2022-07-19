package com.example.recyclerview.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.beans.ItemBean;

import java.util.List;

public abstract class RecyclerViewBaseAdapter extends RecyclerView.Adapter<RecyclerViewBaseAdapter.InnerHolder> {

    private final List<ItemBean>mData;

    public RecyclerViewBaseAdapter(List<ItemBean>mData){
        this.mData=mData;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=getSubView(parent,viewType);

        return new InnerHolder(view);
    }

    protected abstract View getSubView(ViewGroup parent,int viewType);

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {

        holder.setData(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder{

        private TextView icon;
        private TextView title;
        public InnerHolder(@NonNull View itemView) {

            super(itemView);

            //找到控件
            icon =(TextView) itemView.findViewById(R.id.list_view_icon);
            title=(TextView) itemView.findViewById(R.id.list_view_title);

        }


        /**
         *  设置数据
         * @param itemBean
         */
        public void setData(ItemBean itemBean) {

            icon.setText(itemBean.icon);
            title.setText(itemBean.title);

        }
    }
}
