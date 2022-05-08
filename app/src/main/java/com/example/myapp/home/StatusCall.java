package com.example.myapp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.myapp.MainActivity;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.api.Apiservice;
import com.example.myapp.profile_interface.ProfileDataCommet;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusCall extends AppCompatActivity {
    ImageView back;
    Switch call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_call);
        back = findViewById(R.id.imv_home_call_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        call = findViewById(R.id.sw_home_call_dt);
        String status =  MyApplication.getMyApplication().getDataUser().getDoctoriscall();
        if(status.equals("0")){
            call.setChecked(false);
        }else {
            call.setChecked(true);
        }
        call.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true){
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

                    Apiservice.apiservice.turnoncall(body).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            String notice = null;

                            try {
                                notice = response.body().string();
                                if(notice.equals("success")){
                                    Toast.makeText(StatusCall.this, "turned on notifications from calls", Toast.LENGTH_LONG).show();
                                }else {
                                    Toast.makeText(StatusCall.this, "Fail", Toast.LENGTH_LONG).show();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(StatusCall.this, "Fail to Call API", Toast.LENGTH_LONG).show();
                        }
                    });
                }else {
                    //Toast.makeText(StatusCall.this, "turned on notifications from calls", Toast.LENGTH_LONG).show();

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

                    Apiservice.apiservice.turnoffcall(body).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            String notice = null;

                            try {
                                notice = response.body().string();
                                if(notice.equals("success")){
                                    Toast.makeText(StatusCall.this, "turned off notifications from calls", Toast.LENGTH_LONG).show();
                                }else {
                                    Toast.makeText(StatusCall.this, "Fail", Toast.LENGTH_LONG).show();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(StatusCall.this, "Fail to Call API", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }
}