package com.example.tuvanapp;

import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tuvanapp.adapters.DienDanAdapters;
import com.example.tuvanapp.adapters.ThanhTuuAdapters;
import com.example.tuvanapp.models.DienDanModel;
import com.example.tuvanapp.models.ThanhTuuModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DiendanFragment extends Fragment {

    List<DienDanModel> dienDanModelList;
    DienDanAdapters dienDanAdapters;
    RecyclerView recyclerView;
    FirebaseFirestore db;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_diendan, container, false);
        db = FirebaseFirestore.getInstance();


        //View DienDan
        recyclerView = root.findViewById(R.id.diendan);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        dienDanModelList = new ArrayList<>();
        dienDanAdapters = new DienDanAdapters(getActivity(),dienDanModelList);
        recyclerView.setAdapter(dienDanAdapters);

        db.collection("DienDan")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                DienDanModel dienDanModel = document.toObject(DienDanModel.class);
                                dienDanModelList.add(dienDanModel);
                                dienDanAdapters.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        return root;
    }
}