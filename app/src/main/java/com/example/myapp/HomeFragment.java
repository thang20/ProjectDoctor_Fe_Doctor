package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapp.home.AllHospital;
import com.example.myapp.home.Hera;
import com.example.myapp.home.OnlinePharmacy;
import com.example.myapp.home.QADoctor;
import com.example.myapp.home.Services;
import com.example.myapp.home.StatusCall;
import com.example.myapp.home.TakeDateTime;

public class HomeFragment extends Fragment {
    LinearLayout appointment, pharmacy, hera, call, QA, other;
    String role;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        appointment = view.findViewById(R.id.ln_home1);

        pharmacy = view.findViewById(R.id.ln_home3);
        hera = view.findViewById(R.id.ln_home4);
        call = view.findViewById(R.id.ln_home5);
        QA = view.findViewById(R.id.ln_home6);
        other = view.findViewById(R.id.ln_home7);
        role = MyApplication.getMyApplication().getDataUser().getDoctorrole();

        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(role.equals("2")){
                    Toast.makeText(getContext(), "Please register to use this function", Toast.LENGTH_SHORT).show();
                }else if(MyApplication.myApplication.getDataUser().getDoctoristrk().equals("0")){
                    Toast.makeText(getContext(), "This function only Department Heads", Toast.LENGTH_SHORT).show();
                }else {
                    MyApplication.myApplication.getDataUser().setCheckHomeP(0);
                    MyApplication.myApplication.getDataUser().setCheckTestAtHome("0");
                    Intent intent = new Intent(getActivity(), AllHospital.class);
                    startActivity(intent);
                }
            }
        });

        pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(role.equals("2")){
                    Toast.makeText(getContext(), "Please register to use this function", Toast.LENGTH_SHORT).show();
                } else {
                    MyApplication.myApplication.getDataUser().setCheckTestAtHome("0");
                    Intent intent = new Intent(getActivity(), OnlinePharmacy.class);
                    startActivity(intent);
                }

            }
        });
        hera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(role.equals("2")){
                    Toast.makeText(getContext(), "Please register to use this function", Toast.LENGTH_SHORT).show();
                }else {
                    MyApplication.myApplication.getDataUser().setCheckTestAtHome("0");
                    Intent intent = new Intent(getActivity(), Hera.class);
                    startActivity(intent);
                }
            }
        });
        QA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(role.equals("2")){
                    Toast.makeText(getContext(), "Please register to use this function", Toast.LENGTH_SHORT).show();
                }else {
                    MyApplication.myApplication.getDataUser().setCheckTestAtHome("0");
                    Intent intent = new Intent(getActivity(), QADoctor.class);
                    startActivity(intent);
                }
            }
        });
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(role.equals("2")){
                    Toast.makeText(getContext(), "Please register to use this function", Toast.LENGTH_SHORT).show();
                }else if(MyApplication.myApplication.getDataUser().getDoctorist().equals("0")){
                    Toast.makeText(getContext(), "This function only Pharmacy Manager", Toast.LENGTH_SHORT).show();
                }else {
                    MyApplication.myApplication.getDataUser().setCheckHomeP(1);
                    MyApplication.myApplication.getDataUser().setCheckTestAtHome("0");
                    Intent intent = new Intent(getActivity(), Services.class);
                    startActivity(intent);
                }

            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(role.equals("2")){
                    Toast.makeText(getContext(), "Please register to use this function", Toast.LENGTH_SHORT).show();
                }else {
                    MyApplication.myApplication.getDataUser().setCheckHomeP(1);
                    MyApplication.myApplication.getDataUser().setCheckTestAtHome("0");
                    Intent intent = new Intent(getActivity(), StatusCall.class);
                    startActivity(intent);
                }
            }
        });




        return view;
    }
}
