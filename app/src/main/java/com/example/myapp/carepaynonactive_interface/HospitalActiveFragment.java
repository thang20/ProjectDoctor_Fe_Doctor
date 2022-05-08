package com.example.myapp.carepaynonactive_interface;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.hospital.IdentityActiveDoctor;

public class HospitalActiveFragment extends Fragment {
    ImageView face, cc;
    TextView name;
    EditText hospital, spec;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hospital_at, container, false);
        //hospital = view.findViewById(R.id.rcv_hospital);
        face = view.findViewById(R.id.imv_doctor_active_face);
        cc = view.findViewById(R.id.imv_doctor_active_certificate);
        name = view.findViewById(R.id.txt_doctor_active_name);
        hospital = view.findViewById(R.id.edt_doctor_active_hospital);
        spec = view.findViewById(R.id.edt_doctor_active_spec);

        Glide.with(getContext()).load(MyApplication.getMyApplication().getDataUser().getAPI()+MyApplication.getMyApplication().getDataUser().getByteArrayImageStatic()).into(face);
        Glide.with(getContext()).load(MyApplication.getMyApplication().getDataUser().getAPI()+MyApplication.getMyApplication().getDataUser().getDoctorchungchi()).into(cc);
//        Toast.makeText(getContext(), MyApplication.getMyApplication().getDataUser().getAPI()+MyApplication.getMyApplication().getDataUser().getDoctorchungchi(), Toast.LENGTH_SHORT).show();
        name.setText(MyApplication.getMyApplication().getDataUser().getFullNameStatic());
        hospital.setText(MyApplication.getMyApplication().getDataUser().getDoctorhospital());
        spec.setText(MyApplication.getMyApplication().getDataUser().getDoctorspec());



        return view;
    }
}
