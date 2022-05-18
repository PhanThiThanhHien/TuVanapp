package com.example.tuvanapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UommamFragment extends Fragment {

    TextView hypebq, hypeng;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_uommam, container, false);

        hypebq = root.findViewById(R.id.biquyet);
        hypebq.setMovementMethod(LinkMovementMethod.getInstance());

        hypeng = root.findViewById(R.id.ngu);
        hypeng.setMovementMethod(LinkMovementMethod.getInstance());

        return root;


    }
}