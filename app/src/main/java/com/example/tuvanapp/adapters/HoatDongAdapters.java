package com.example.tuvanapp.adapters;

import android.content.Context;
import android.content.Intent;
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

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HoatDongAdapters  extends RecyclerView.Adapter<HoatDongAdapters.ViewHoder> {

    private Context context;
    private List<HoatDongModel> hoatdongModelList;

    public HoatDongAdapters(Context context, List<HoatDongModel> hoatdongModelList) {
        this.context = context;
        this.hoatdongModelList = hoatdongModelList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHoder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hoatdong_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {

        Glide.with(context).load(hoatdongModelList.get(position).getImage()).into(holder.hdImg);
        holder.title.setText(hoatdongModelList.get(position).getTitle());
        holder.addess.setText(hoatdongModelList.get(position).getAddress());
        holder.time.setText(hoatdongModelList.get(position).getTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ViewHDActivity.class);
                intent.putExtra("type", hoatdongModelList.get(position).getType());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return hoatdongModelList.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        ImageView hdImg;
        TextView title, addess, time;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            hdImg = itemView.findViewById(R.id.hd_img);
            title = itemView.findViewById(R.id.hd_tt);
            addess = itemView.findViewById(R.id.hd_adr);
            time = itemView.findViewById(R.id.hd_time);
        }
    }
}
