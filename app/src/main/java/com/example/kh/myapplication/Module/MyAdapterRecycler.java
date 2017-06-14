package com.example.kh.myapplication.Module;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kh.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kh on 6/14/2017.
 */

public class MyAdapterRecycler extends RecyclerView.Adapter<MyAdapterRecycler.MyViewHolder>{
    private List<Contact> list = new ArrayList<Contact>();
    private Context context;
    public MyAdapterRecycler(Context context, List<Contact> list){
        this.context  =context;
        this.list = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.myrow,parent,false);
        MyViewHolder holder  =new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txtEmail.setText(list.get(position).getEmail());
        holder.txtId.setText(String.valueOf( list.get(position).getId()));
        holder.txtName.setText(list.get(position).getName());
        holder.txtPhone.setText(list.get(position).getPhone());
        Picasso.with(context).load("http://192.168.1.10/"+list.get(position).getSrc()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.txtEmail)
        TextView txtEmail;
        @BindView(R.id.txtId)
        TextView txtId;
        @BindView(R.id.txtPhone)
        TextView txtPhone;
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.imgView)
        ImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
