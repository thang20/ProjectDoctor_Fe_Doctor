package com.example.myapp.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.api.Apiservice;
import com.example.myapp.data.ItemNewDataSpecservice;
import com.example.myapp.data.ItemNewDataSpecserviceAdapter;
import com.example.myapp.data.ItemNewHomeoneDataHospital;
import com.example.myapp.data.ItemNewHomeoneDataHospitalAdapter;
import com.example.myapp.data.ItemProfileData01;
import com.example.myapp.data.ItemProfileData01Adapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartMedical extends AppCompatActivity {
    Spinner service;
    RecyclerView allSv;
    ImageView back;
    ItemNewDataSpecserviceAdapter itemNewDataSpecserviceAdapter;
    Button add, delete, next;
    String exService = "";
    List<ItemNewDataSpecservice> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_medical);
        service = findViewById(R.id.spl_ex_service_cservice);
        allSv = findViewById(R.id.rcv_ex_service_allSv);
        back = findViewById(R.id.imv_ex_service_back);
        add = findViewById(R.id.btn_ex_service_add);
        delete = findViewById(R.id.btn_ex_service_delete);
        next = findViewById(R.id.btn_ex_service_next);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        JSONObject jsonObject = new JSONObject();
        String jsonStr = null;
        try {
            String email = MyApplication.getMyApplication().getDataUser().getEmailStatic();
            jsonObject = new JSONObject();
            jsonObject.put("email", email);
            jsonStr = jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), jsonStr);

        Apiservice.apiservice.takeserviceofspec(body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                String notice = "";
                try {
                    ArrayList<String> arrayList = new ArrayList<String>();
                    notice = response.body().string();
                    List<ItemNewHomeoneDataHospital> list = new ArrayList<ItemNewHomeoneDataHospital>();
                    List<String> data = new ArrayList<String>(Arrays.asList(notice.split(",-,")));
                    for (int i = 0; i < data.size(); i++) {

                        String datajson = data.get(i);
                        JSONObject obj = new JSONObject(datajson);
                        String name = obj.get("name").toString();

                        arrayList.add(name);
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter(StartMedical.this, android.R.layout.simple_spinner_item, arrayList);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    service.setAdapter(arrayAdapter);



                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
        allSv.setLayoutManager(new LinearLayoutManager(StartMedical.this));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(StartMedical.this, DividerItemDecoration.VERTICAL);
        allSv.addItemDecoration(itemDecoration);





        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = service.getSelectedItem().toString();
                list.add(new ItemNewDataSpecservice(text));
                itemNewDataSpecserviceAdapter = new ItemNewDataSpecserviceAdapter(StartMedical.this ,list);
                allSv.setAdapter(itemNewDataSpecserviceAdapter);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(list.size()!=0) {
                    list.remove(list.size() - 1);
                    itemNewDataSpecserviceAdapter = new ItemNewDataSpecserviceAdapter(StartMedical.this, list);
                    allSv.setAdapter(itemNewDataSpecserviceAdapter);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.myApplication.getDataUser().setListSPECSERVICE(list);
                for (int i = 0; i<list.size(); i++){
                    exService = exService +"-"+list.get(i).getName();
                    //Log.d("checkl", exService);
                }
                JSONObject jsonObject = new JSONObject();
                String jsonStr = null;
                try {
                    String email = MyApplication.getMyApplication().getDataUser().getEmailStatic();
                    jsonObject = new JSONObject();
                    jsonObject.put("email", email);
                    jsonObject.put("ex", exService);
                    jsonObject.put("idl", MyApplication.myApplication.getDataUser().getBenhnhanIDL());
                    jsonStr = jsonObject.toString();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestBody body =
                        RequestBody.create(MediaType.parse("text/plain"), jsonStr);

                Apiservice.apiservice.createex(body).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String notice = null;
                        try {
                            notice = response.body().string();
                            if(notice.equals("success")){
                                Toast.makeText(StartMedical.this, "Success", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(StartMedical.this, AllHospital.class));
                                finish();

                            }else {
                                Toast.makeText(StartMedical.this, "Fail", Toast.LENGTH_LONG).show();
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });

            }
        });

    }


}