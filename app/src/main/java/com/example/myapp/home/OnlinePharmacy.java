package com.example.myapp.home;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.Home;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.api.Apiservice;
import com.example.myapp.data.ItemNewDataPost;
import com.example.myapp.data.ItemNewDataPostAdapter;
import com.example.myapp.data.ItemNewDataThuoc;
import com.example.myapp.data.ItemNewDataThuocAdapter;
import com.example.myapp.profile_interface.UpdateProfile;
import com.github.dhaval2404.imagepicker.ImagePicker;

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

public class OnlinePharmacy extends AppCompatActivity {
    RecyclerView thuoc;
    ImageView back;
    ItemNewDataThuocAdapter itemNewDataThuocAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_pharmacy);
        back = findViewById(R.id.imv_home_thuoc_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        thuoc = findViewById(R.id.rcv_drugOrder);
        progressDialog = new ProgressDialog(OnlinePharmacy.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.process_dialog);

        thuoc.setLayoutManager(new LinearLayoutManager(OnlinePharmacy.this));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(OnlinePharmacy.this, DividerItemDecoration.VERTICAL);
        thuoc.addItemDecoration(itemDecoration);
//        itemNewDataPostAdapter = new ItemNewDataPostAdapter(getContext() ,getListData());
//        imageViewNew.setAdapter(itemNewDataPostAdapter);
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

        Apiservice.apiservice.allthuoc(body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String notice = "";
                try {
                    notice = response.body().string();
                    List<ItemNewDataThuoc> list = new ArrayList<ItemNewDataThuoc>();
                    List<String> data = new ArrayList<String>(Arrays.asList(notice.split(",-,")));
                    for (int i = 0; i < data.size(); i++) {

                        String datajson = data.get(i);
                        Log.d("data", String.valueOf(i));
                        JSONObject obj = new JSONObject(datajson);


                        String image = obj.get("image").toString();
                        String phone = obj.get("phone").toString();
                        String address = obj.get("address").toString();
                        String name = obj.get("name").toString();
                        String ID = obj.get("ID").toString();



                        list.add(new ItemNewDataThuoc(name,
                                address,image, phone, ID));







                    }
                    itemNewDataThuocAdapter = new ItemNewDataThuocAdapter(OnlinePharmacy.this ,list);
                    thuoc.setAdapter(itemNewDataThuocAdapter);
                    progressDialog.dismiss();


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