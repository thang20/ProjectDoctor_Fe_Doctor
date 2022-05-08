package com.example.myapp.profile_interface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapp.Home;
import com.example.myapp.Login;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.api.Apiservice;
import com.example.myapp.data.DataUser;
import com.example.myapp.data.ItemProfileData01;
import com.example.myapp.data.ItemProfileData01Adapter;
import com.example.myapp.data.ItemProfileDataRelative;
import com.example.myapp.data.ItemProfileDataRelativeAdapter;
import com.example.myapp.data.ItemProfileDataSchedule;
import com.example.myapp.data.ItemProfileDataScheduleAdapter;

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

public class ProfileDataSchedule extends AppCompatActivity {
    RecyclerView recyclerViewSchedule;
    ImageView back;
    TextView add;
    ItemProfileDataScheduleAdapter itemProfileDataScheduleAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_data_schedule);

        recyclerViewSchedule = findViewById(R.id.rcv_profile_schedule);
        back = findViewById(R.id.imw_profile_schedule_back);
        add = findViewById(R.id.txt_profile_schedule_add);
        recyclerViewSchedule.setLayoutManager(new LinearLayoutManager(ProfileDataSchedule.this));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(ProfileDataSchedule.this, DividerItemDecoration.VERTICAL);
        recyclerViewSchedule.addItemDecoration(itemDecoration);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProfileDataScheduleAdd.class));
                finish();
            }
        });

        progressDialog = new ProgressDialog(ProfileDataSchedule.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.process_dialog);

        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        String semail =  MyApplication.getMyApplication().getDataUser().getEmailStatic();

        JSONObject jsonObject = new JSONObject();
        String jsonStr = null;
        try {

            jsonObject = new JSONObject();
            jsonObject.put("email", semail);
            jsonStr = jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), jsonStr);

        Apiservice.apiservice.profileschedule(body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String notice = null;
                try {
                    notice = response.body().string();
                    List<ItemProfileDataSchedule> list = new ArrayList<>();
                    List<String> data = new ArrayList<String>(Arrays.asList(notice.split(",-,")));
                    for (int i = 0; i < data.size(); i++) {

                        String datajson = data.get(i);
                        Log.d("data", String.valueOf(i));
                        JSONObject obj = new JSONObject(datajson);


                        String remind = obj.get("remind").toString();
                        String time = obj.get("time").toString();
                        String date = obj.get("date").toString();

                        time = " " + time;
                        date = "Date: " + date;

                        list.add(new ItemProfileDataSchedule(remind,
                                time,date ));


                        itemProfileDataScheduleAdapter = new ItemProfileDataScheduleAdapter(ProfileDataSchedule.this ,list);
                        recyclerViewSchedule.setAdapter(itemProfileDataScheduleAdapter);
                        progressDialog.dismiss();



                    }

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    @Override
    public void onRestart() {
        super.onRestart();


        String semail =  MyApplication.getMyApplication().getDataUser().getEmailStatic();

        JSONObject jsonObject = new JSONObject();
        String jsonStr = null;
        try {

            jsonObject = new JSONObject();
            jsonObject.put("email", semail);
            jsonStr = jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), jsonStr);

        Apiservice.apiservice.profileschedule(body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String notice = null;
                try {
                    notice = response.body().string();
                    List<ItemProfileDataSchedule> list = new ArrayList<>();
                    List<String> data = new ArrayList<String>(Arrays.asList(notice.split(",-,")));
                    for (int i = 0; i < data.size(); i++) {

                        String datajson = data.get(i);
                        Log.d("data", String.valueOf(i));
                        JSONObject obj = new JSONObject(datajson);


                        String remind = obj.get("remind").toString();
                        String time = obj.get("time").toString();
                        String date = obj.get("date").toString();

                        time = " " + time;
                        date = "Date: " + date;

                        list.add(new ItemProfileDataSchedule(remind,
                                time,date ));


                        itemProfileDataScheduleAdapter = new ItemProfileDataScheduleAdapter(ProfileDataSchedule.this ,list);
                        recyclerViewSchedule.setAdapter(itemProfileDataScheduleAdapter);



                    }

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }


}