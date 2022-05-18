package com.example.tuvanapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tuvanapp.R;
import com.example.tuvanapp.activities.ViewHDActivity;
import com.example.tuvanapp.models.HoatDongModel;
import com.example.tuvanapp.models.ViewHDModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ViewHDAdapters extends RecyclerView.Adapter<ViewHDAdapters.ViewHolder> {

    Context context;
    List<ViewHDModel> list;

    public ViewHDAdapters(Context context, List<ViewHDModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhd_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        Glide.with(context).load(list.get(position).getImage()).into(holder.hdImg);
        holder.title.setText(list.get(position).getTitle());
        holder.addess.setText(list.get(position).getAddress());
        holder.time.setText(list.get(position).getTime());
        holder.content.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView hdImg;
        TextView title, addess, time, content;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            hdImg = itemView.findViewById(R.id.viewhd_img);
            title = itemView.findViewById(R.id.viewhd_tt);
            content = itemView.findViewById(R.id.viewhd_ctn);
            addess = itemView.findViewById(R.id.viewhd_adr);
            time = itemView.findViewById(R.id.viewhd_time);

        }
    }
}
