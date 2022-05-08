package com.example.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.api.Apiservice;
import com.example.myapp.carepaynonactive_interface.IDCard;
import com.example.myapp.data.ItemNewDataHospital;
import com.example.myapp.data.ItemNewDataHospitalAdapter;
import com.example.myapp.data.ItemNewDataPost;
import com.example.myapp.data.ItemNewDataPostAdapter;
import com.example.myapp.hospital.IdentityActiveDoctor;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalFragment extends Fragment {
    LinearLayout start;
    TextView name;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hospital, container, false);
        //hospital = view.findViewById(R.id.rcv_hospital);
        name = (TextView) view.findViewById(R.id.txt_active_doctor_non_name);
        start = (LinearLayout) view.findViewById(R.id.ln_active_doctor_non_start);
        name.setText("Hello " + MyApplication.getMyApplication().getDataUser().getFullNameStatic() + "!");
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), IdentityActiveDoctor.class);
                startActivity(intent);
            }
        });



        return view;
    }
}
