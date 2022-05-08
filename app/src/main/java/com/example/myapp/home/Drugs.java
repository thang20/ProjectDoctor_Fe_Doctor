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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapp.MainActivity;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.api.Apiservice;
import com.example.myapp.data.ItemNewDataAdddrug;
import com.example.myapp.data.ItemNewDataAdddrugAdapter;
import com.example.myapp.data.ItemNewDataSpecservice;
import com.example.myapp.data.ItemNewDataSpecserviceAdapter;
import com.example.myapp.data.ItemNewEx;
import com.example.myapp.data.ItemNewExAdapter;
import com.example.myapp.data.ItemNewHomeoneDataHospital;
import com.example.myapp.data.ItemNewHomeoneDataHospitalAdapter;

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

public class Drugs extends AppCompatActivity {
    RecyclerView allEx, allDrug;
    ImageView back;
    Spinner choiceDrug;
    ItemNewExAdapter itemNewExAdapter;
    EditText  number;
    Button add, delete, next;
    String DrugALL = "";
    List<ItemNewDataAdddrug> listA = new ArrayList<>();
    ItemNewDataAdddrugAdapter itemNewDataAdddrugAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drugs);
        allEx = findViewById(R.id.rcv_doctor_dug_ex);
        allDrug = findViewById(R.id.rcv_doctor_dug_alldug);
        back = findViewById(R.id.imv_doctor_dug_back);
        choiceDrug = findViewById(R.id.spl_doctor_dug_d);
        number = findViewById(R.id.edt_doctor_dug_number);
        add = findViewById(R.id.btn_doctor_dug_add);
        delete = findViewById(R.id.btn_doctor_dug_delete);
        next = findViewById(R.id.btn_doctor_dug_next);

        allEx.setLayoutManager(new LinearLayoutManager(Drugs.this));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Drugs.this, DividerItemDecoration.VERTICAL);
        allEx.addItemDecoration(itemDecoration);
        String notice = MyApplication.myApplication.getDataUser().getBenhnhanEX();
        List<ItemNewEx> list = new ArrayList<ItemNewEx>();
        List<String> data = new ArrayList<String>(Arrays.asList(notice.split("-")));
        for (int i = 1; i < data.size(); i++) {
            list.add(new ItemNewEx(data.get(i)));
        }

        itemNewExAdapter = new ItemNewExAdapter(Drugs.this ,list);
        allEx.setAdapter(itemNewExAdapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        /////////////////////////////
        JSONObject jsonObject = new JSONObject();
        String jsonStr = null;
        try {
            String hospital = MyApplication.getMyApplication().getDataUser().getDoctorhospital();
            jsonObject = new JSONObject();
            jsonObject.put("hospital", hospital);
            jsonStr = jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), jsonStr);

        Apiservice.apiservice.takeallthuoc(body).enqueue(new Callback<ResponseBody>() {
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
                        String name = obj.get("drug").toString();
                        arrayList.add(name);
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter(Drugs.this, android.R.layout.simple_spinner_item, arrayList);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    choiceDrug.setAdapter(arrayAdapter);



                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
        allDrug.setLayoutManager(new LinearLayoutManager(Drugs.this));
//        RecyclerView.ItemDecoration itemDecoration1 = new DividerItemDecoration(Drugs.this, DividerItemDecoration.VERTICAL);
//        allDrug.addItemDecoration(itemDecoration1);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = choiceDrug.getSelectedItem().toString();
                String n = number.getText().toString();
                listA.add(new ItemNewDataAdddrug(text, n));
                itemNewDataAdddrugAdapter = new ItemNewDataAdddrugAdapter(Drugs.this ,listA);
                allDrug.setAdapter(itemNewDataAdddrugAdapter);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listA.size()!=0) {
                    listA.remove(listA.size() - 1);
                    itemNewDataAdddrugAdapter = new ItemNewDataAdddrugAdapter(Drugs.this, listA);
                    allDrug.setAdapter(itemNewDataAdddrugAdapter);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i<listA.size(); i++){
                    DrugALL = DrugALL +"-"+listA.get(i).getName() + "+" + listA.get(i).getNumber() ;
                    //Log.d("checkl", exService);
                }
                JSONObject jsonObject = new JSONObject();
                String jsonStr = null;
                try {
                    String email = MyApplication.getMyApplication().getDataUser().getEmailStatic();
                    jsonObject = new JSONObject();
                    jsonObject.put("email", email);
                    jsonObject.put("drug", DrugALL);
                    jsonObject.put("kq", MyApplication.myApplication.getDataUser().getBenhnhanThuoc());
                    jsonObject.put("idl", MyApplication.myApplication.getDataUser().getBenhnhanIDL());
                    jsonStr = jsonObject.toString();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestBody body =
                        RequestBody.create(MediaType.parse("text/plain"), jsonStr);

                Apiservice.apiservice.ktkethuoc(body).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String notice = null;

                        try {
                            notice = response.body().string();
                            if(notice.equals("success")){
                                Toast.makeText(Drugs.this, "Success", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(Drugs.this, Services.class));
                                finish();

                            }else {
                                Toast.makeText(Drugs.this, "Fail", Toast.LENGTH_LONG).show();
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