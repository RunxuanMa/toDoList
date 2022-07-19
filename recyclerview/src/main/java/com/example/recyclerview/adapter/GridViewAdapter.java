package com.example.recyclerview.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.beans.ItemBean;

import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.InnerHolder> {
    private final List<ItemBean>mData;
    public GridViewAdapter(List<ItemBean>data){
        mData=data;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_gird_view, null);
        return new InnerHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {

        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData!=null){
            return mData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private String text;
        private TextView Title;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            Title =(TextView) itemView.findViewById(R.id.grid_view_text);
        }

        public void setData(ItemBean itemBean) {
            this.text=itemBean.title;
            Title.setText(text);
        }
    }
}
