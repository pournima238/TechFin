package com.example.techfin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Contact> arrayList;






    public DataAdapter( ArrayList<Contact> arrayList) {

        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact data=arrayList.get(position);
    holder.name.setText(data.getTitle());
    holder.ids.setText(String.valueOf(data.getId()));
    //Glide.with(context).load(arrayList.get(position).getImage()).into(holder.imageView);
        Glide.with(holder.itemView.getContext()).load(arrayList.get(position).getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    TextView name;
    TextView ids;
    private  ImageView imageView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.name);
        ids=itemView.findViewById(R.id.ids);
        imageView=itemView.findViewById(R.id.imageView);

    }
}
}
