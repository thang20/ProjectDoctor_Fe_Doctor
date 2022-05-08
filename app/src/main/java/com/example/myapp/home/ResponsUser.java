package com.example.myapp.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapp.MyApplication;
import com.example.myapp.New_interface.Comment_New;
import com.example.myapp.R;
import com.example.myapp.api.Apiservice;
import com.example.myapp.data.ItemNewDataComment;
import com.example.myapp.data.ItemNewDataCommentAdapter;
import com.github.dhaval2404.imagepicker.ImagePicker;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResponsUser extends AppCompatActivity {
    ImageView back, face, send;
    TextView name, date, time, content;
    RecyclerView commet;
    Uri muir = null;
    String img;
    ItemNewDataCommentAdapter itemNewDataCommentAdapter;
    ProgressDialog progressDialog;
    EditText commetText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respons_user);
        back = findViewById(R.id.imv_item_new_comment_DT_back);
        face = findViewById(R.id.rcv_item_new_comment_DT_imageFace);
        name = findViewById(R.id.txt_item_new_comment_DT_fullName);
        date = findViewById(R.id.txt_item_new_comment_DT_date);
        time = findViewById(R.id.txt_item_new_comment_DT_time);
        content = findViewById(R.id.txt_item_new_comment_DT_content);
        send = findViewById(R.id.imv_item_new_comment_DT_send);
        commet = findViewById(R.id.rcv_comment_DT);
        commetText = findViewById(R.id.txt_item_new_comment_DT_comment);

        commet.setLayoutManager(new LinearLayoutManager(ResponsUser.this));
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(Comment_New.this, DividerItemDecoration.VERTICAL);
//        commet.addItemDecoration(itemDecoration);

        content.setText(MyApplication.getMyApplication().getDataUser().getCommentContent());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        String checkFace = MyApplication.getMyApplication().getDataUser().getCommentImageFace();

        if(checkFace.equals("")){
            face.setImageResource(R.drawable.profile);
        }
        else {
//            face.setImageURI(Uri.parse(checkFace));
            Glide.with(ResponsUser.this).load(MyApplication.getMyApplication().getDataUser().getAPI()+checkFace).into(face);
        }



        String dateCheck = MyApplication.getMyApplication().getDataUser().getCommentDate();
        if(dateCheck.equals(new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()))){
            Calendar cal = Calendar.getInstance();
            String timepost = MyApplication.getMyApplication().getDataUser().getCommentTime();
            String[] parts = timepost.split(":");
            int hourp = Integer.parseInt(parts[0]);
            int mip = Integer.parseInt(parts[1]);

            int minute = cal.get(Calendar.MINUTE);
            int hourofday = cal.get(Calendar.HOUR_OF_DAY);
            if(hourp!=hourofday){
                int changeH = hourofday - hourp;
                time.setText(String.valueOf(changeH) + " hour ago");

            }else {
                int changeP = minute - mip;
                if(changeP<=1){
                    time.setText("now");
                }else {

                    time.setText(String.valueOf(changeP) + " minute ago");
                }
            }

        }else {

            date.setText(MyApplication.getMyApplication().getDataUser().getCommentDate());
            time.setText(MyApplication.getMyApplication().getDataUser().getCommentTime());

        }
        name.setText(MyApplication.getMyApplication().getDataUser().getCommentFullName());
        commetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send.setColorFilter(Color.parseColor("#2BC4BF"));
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content =  commetText.getText().toString();
                if(content.length()==0){
                    Toast.makeText(ResponsUser.this, "Please input a comment", Toast.LENGTH_LONG).show();
                }else {

                    JSONObject jsonObject = new JSONObject();
                    String jsonStr = null;
                    try {
                        jsonObject = new JSONObject();
                        String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
                        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());

                        jsonObject.put("content", content);
                        jsonObject.put("date", currentDate);
                        jsonObject.put("time", currentTime);
                        jsonObject.put("idpeople", MyApplication.myApplication.getDataUser().getEmailStatic());
                        jsonObject.put("idpost", MyApplication.myApplication.getDataUser().getCommentIDPost());
                        jsonStr = jsonObject.toString();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    RequestBody body =
                            RequestBody.create(MediaType.parse("text/plain"), jsonStr);

                    Apiservice.apiservice.postacommentdt(body).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            String notice = null;

                            try {
                                notice = response.body().string();
                                if(notice.equals("success")){
                                    commetText.setText("");
                                    Toast.makeText(ResponsUser.this, "Success", Toast.LENGTH_LONG).show();
                                    UpdateComment();

                                }else {
                                    Toast.makeText(ResponsUser.this, "Fail to comment", Toast.LENGTH_LONG).show();
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(ResponsUser.this, "Fail to Call API", Toast.LENGTH_LONG).show();

                        }
                    });
                }
            }
        });
        UpdateComment();



    }
    private void UpdateComment(){

        progressDialog = new ProgressDialog(ResponsUser.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.process_dialog);

        JSONObject jsonObject = new JSONObject();
        String jsonStr = null;
        try {

            jsonObject = new JSONObject();
            jsonObject.put("idpeople", MyApplication.myApplication.getDataUser().getCommentIDPeople());
            jsonObject.put("idpost", MyApplication.myApplication.getDataUser().getCommentIDPost());
            jsonStr = jsonObject.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body =
                RequestBody.create(MediaType.parse("text/plain"), jsonStr);

        Apiservice.apiservice.allcommentdt(body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String notice = "";
                try {
                    notice = response.body().string();
                    List<ItemNewDataComment> list = new ArrayList<ItemNewDataComment>();
                    List<String> data = new ArrayList<String>(Arrays.asList(notice.split(",-,")));
                    for (int i = 0; i < data.size(); i++) {

                        String datajson = data.get(i);
                        Log.d("data", String.valueOf(i));
                        JSONObject obj = new JSONObject(datajson);


                        String content = obj.get("content").toString();

                        String date = obj.get("date").toString();
                        String time = obj.get("time").toString();
                        String image = obj.get("image").toString();
                        String imageface = obj.get("imageface").toString();
                        String fullname = obj.get("fullname").toString();



                        list.add(new ItemNewDataComment(imageface,
                                time, date, fullname, image, content));



                    }


                    itemNewDataCommentAdapter = new ItemNewDataCommentAdapter(ResponsUser.this ,list);
                    commet.setAdapter(itemNewDataCommentAdapter);
                    progressDialog.dismiss();



                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressDialog.dismiss();

            }
        });

    }
}