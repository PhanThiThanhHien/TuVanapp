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
import com.example.tuvanapp.models.ThanhTuuModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ThanhTuuAdapters extends RecyclerView.Adapter<ThanhTuuAdapters.ViewHoder> {

    private Context context;
    private List<ThanhTuuModel> thanhtuuModelList;

    public ThanhTuuAdapters(Context context, List<ThanhTuuModel> thanhtuuModelList) {
        this.context = context;
        this.thanhtuuModelList = thanhtuuModelList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHoder(LayoutInflater.from(parent.getContext()).inflate(R.layout.thanhtuu_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHoder holder, int position) {
        Glide.with(context).load(thanhtuuModelList.get(position).getImage()).into(holder.ttImg);
        holder.title.setText(thanhtuuModelList.get(position).getTitle());
        holder.content.setText(thanhtuuModelList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return thanhtuuModelList.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        ImageView ttImg;
        TextView title, content;

        public ViewHoder(@NonNull @NotNull View itemView) {
            super(itemView);

            ttImg = itemView.findViewById(R.id.tt_img);
            title = itemView.findViewById(R.id.tt_tt);
            content= itemView.findViewById(R.id.tt_cnt);
        }
    }
}
