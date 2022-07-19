package com.example.todolist.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.todolist.Bean.ItemBean;
import com.example.todolist.MainActivity;
import com.example.todolist.R;

import java.util.Date;
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {


        View view = holder.itemView;

        holder.setData(mData.get(position));

        holder.content.setOnClickListener(l->{
            String string = holder.content.getText().toString();
            holder.editText.setText(string);
            holder.editText.setVisibility(EditText.VISIBLE);
            holder.content.setVisibility(TextView.GONE);

        });

        holder.editText.setOnClickListener(l->{
            String string = holder.editText.getText().toString();
            holder.editText.setVisibility(View.INVISIBLE);
            holder.content.setText(string);
            holder.content.setVisibility(View.VISIBLE);
            MainActivity.dao.update(string,holder.id.getText().toString());
        });

    }

    @Override
    public int getItemCount() {
        if (mData==null){
            return 0;
        }
        return mData.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder{

        private TextView icon;
        private TextView title;
        private  TextView id;
        private TextView content;
        private TextView created;
        private TextView status;
        private TextView updated;
        private View itemView;
        private EditText editText;
        public InnerHolder(@NonNull View itemView) {

            super(itemView);

            this.itemView=itemView;

            //找到控件

             id =(TextView) itemView.findViewById(R.id.listView_ID);
             content =(TextView) itemView.findViewById(R.id.listView_content);
             created =(TextView) itemView.findViewById(R.id.listView_created);
             status =(TextView) itemView.findViewById(R.id.listView_status);
             updated =(TextView) itemView.findViewById(R.id.listView_updated);
             editText=(EditText) itemView.findViewById(R.id.listView_EditText);


        }




        /**
         *  设置数据
         * @param itemBean
         */
        public void setData(ItemBean itemBean) {
            if(itemBean.getContent()==null){
                return;
            }

                    id.setText("Id:"+String.valueOf(itemBean.getID()));
                    content.setText(itemBean.getContent());
                    created.setText((String.valueOf(itemBean.getCreated())));
                    updated.setText((String.valueOf(itemBean.getUpdated())));
                    status.setText((String.valueOf(itemBean.getStatus())));
                }

        }

//        private void Click(){
//            onClick(this.itemView);
//        }
//
//        @Override
//        public void onClick(View v) {
//
//            Log.e("jj","jjoo");
//            System.out.println("爬");
//
//        }
    }

