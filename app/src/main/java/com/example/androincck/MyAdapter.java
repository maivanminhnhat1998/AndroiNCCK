package com.example.androincck;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androincck.Model.ContactModel;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<ContactModel> models;
    int mResource;
    Context mContext;
    public MyAdapter(Context context,int resource, List<ContactModel> objects){
        this.mContext = context;
        this.mResource = resource;
        this.models = objects;
    }
    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(mResource,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {
        ContactModel contactModel = models.get(i);
        viewHolder.tvTenMH.setText(contactModel.getTenMH());
        viewHolder.tvMaMH.setText(contactModel.getMaMH());
        viewHolder.tvTinhChi.setText(contactModel.getTinhChi()+"");
        viewHolder.tvDescription.setText(contactModel.getDescription());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenMH;
        TextView tvMaMH;
        TextView tvTinhChi;
        TextView tvDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvTenMH = itemView.findViewById(R.id.tvTenMH);
            this.tvMaMH = itemView.findViewById(R.id.tvMaMH);
            this.tvTinhChi = itemView.findViewById(R.id.tvTinhChi);
            this.tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
