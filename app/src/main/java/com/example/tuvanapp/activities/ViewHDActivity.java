package com.example.tuvanapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tuvanapp.R;
import com.example.tuvanapp.adapters.ViewHDAdapters;
import com.example.tuvanapp.models.ViewHDModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ViewHDActivity extends AppCompatActivity {

    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    ViewHDAdapters viewHDAdapters;
    List<ViewHDModel> viewHDModelList;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_hdactivity);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firestore = FirebaseFirestore.getInstance();
        String type = getIntent().getStringExtra("type");
        recyclerView = findViewById(R.id.viewhoatdong);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewHDModelList = new ArrayList<>();
        viewHDAdapters = new ViewHDAdapters(this, viewHDModelList);
        recyclerView.setAdapter(viewHDAdapters);

        // Get diemso
        if (type != null && type.equalsIgnoreCase("diemso")){
            firestore.collection("ViewHoatDong").whereEqualTo("type", "diemso").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot:task.getResult().getDocuments()){
                        ViewHDModel viewHDModel = documentSnapshot.toObject(ViewHDModel.class);
                        viewHDModelList.add(viewHDModel);
                        viewHDAdapters.notifyDataSetChanged();
                    }
                }
            });
        }

        // Get diemso
        if (type != null && type.equalsIgnoreCase("camtrai")){
            firestore.collection("ViewHoatDong").whereEqualTo("type", "camtrai").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot:task.getResult().getDocuments()){
                        ViewHDModel viewHDModel = documentSnapshot.toObject(ViewHDModel.class);
                        viewHDModelList.add(viewHDModel);
                        viewHDAdapters.notifyDataSetChanged();
                    }
                }
            });
        }

        // Get diemso
        if (type != null && type.equalsIgnoreCase("ketban")){
            firestore.collection("ViewHoatDong").whereEqualTo("type", "ketban").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot:task.getResult().getDocuments()){
                        ViewHDModel viewHDModel = documentSnapshot.toObject(ViewHDModel.class);
                        viewHDModelList.add(viewHDModel);
                        viewHDAdapters.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}