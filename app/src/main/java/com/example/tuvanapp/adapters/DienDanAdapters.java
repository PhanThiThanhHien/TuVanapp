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
import com.example.tuvanapp.models.DienDanModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DienDanAdapters extends RecyclerView.Adapter<DienDanAdapters.ViewHolder> {

    Context context;
    List<DienDanModel> list;

    public DienDanAdapters(Context context, List<DienDanModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.diendan_item,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {

        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);
        holder.content.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView content;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.dd_img);
            content = itemView.findViewById(R.id.dd_cnt);

        }
    }
}
