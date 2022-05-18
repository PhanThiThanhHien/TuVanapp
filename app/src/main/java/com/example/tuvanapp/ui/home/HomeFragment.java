package com.example.tuvanapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuvanapp.R;
import com.example.tuvanapp.adapters.HoatDongAdapters;
import com.example.tuvanapp.adapters.ThanhTuuAdapters;
import com.example.tuvanapp.models.HoatDongModel;
import com.example.tuvanapp.models.ThanhTuuModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView hoatdongRec, thanhtuuRec;

    FirebaseFirestore db;

    //hoatdong items
    List<HoatDongModel> hoatdongModelList;
    HoatDongAdapters hoatdongAdapters;

    //thanhtuu items
    List<ThanhTuuModel> thanhtuuModelList;
    ThanhTuuAdapters thanhtuuAdapters;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

       final View root = inflater.inflate(R.layout.fragment_home, container, false);
        db = FirebaseFirestore.getInstance();

        //View HoatDong
        hoatdongRec = root.findViewById(R.id.hoatdong);
        hoatdongRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        hoatdongModelList = new ArrayList<>();
        hoatdongAdapters = new HoatDongAdapters(getActivity(),hoatdongModelList);
        hoatdongRec.setAdapter(hoatdongAdapters);

        db.collection("HoatDong")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                HoatDongModel hoatdongModel = document.toObject(HoatDongModel.class);
                                hoatdongModelList.add(hoatdongModel);
                                hoatdongAdapters.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        //View ThanhTuu
        thanhtuuRec = root.findViewById(R.id.thanhtuu);
        thanhtuuRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        thanhtuuModelList = new ArrayList<>();
        thanhtuuAdapters = new ThanhTuuAdapters(getActivity(),thanhtuuModelList);
        thanhtuuRec.setAdapter(thanhtuuAdapters);

        db.collection("ThanhTuu")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                ThanhTuuModel thanhtuuModel = document.toObject(ThanhTuuModel.class);
                                thanhtuuModelList.add(thanhtuuModel);
                                thanhtuuAdapters.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        return root;
    }

}