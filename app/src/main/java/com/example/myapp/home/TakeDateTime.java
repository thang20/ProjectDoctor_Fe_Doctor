package com.example.myapp.home;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.Login;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.profile_interface.ProfileDataScheduleAdd;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TakeDateTime extends AppCompatActivity {
    ImageView back;
    Button next;
    TextView service, hService, time1, time2, time3, time4, time5, time6, time7, time8, time9, time10, time11, time12, time13, time14, time15, time16;
    EditText spinnerDate;
    DatePickerDialog datepicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_date_time);
        back = findViewById(R.id.imv_home_home1_appointment_back);
        service = findViewById(R.id.txt_home_home1_appointment_service);
        hService = findViewById(R.id.txt_home_home1_appointment_hService);
        spinnerDate = findViewById(R.id.spn_home_home1_appointment_date);
        next = findViewById(R.id.btn_home_home1_appointment_next);
        time1 = findViewById(R.id.txt_home_home1_appointment_time1);
        time2 = findViewById(R.id.txt_home_home1_appointment_time2);
        time3 = findViewById(R.id.txt_home_home1_appointment_time3);
        time4 = findViewById(R.id.txt_home_home1_appointment_time4);
        time5 = findViewById(R.id.txt_home_home1_appointment_time5);
        time6 = findViewById(R.id.txt_home_home1_appointment_time6);
        time7 = findViewById(R.id.txt_home_home1_appointment_time7);
        time8 = findViewById(R.id.txt_home_home1_appointment_time8);
        time9 = findViewById(R.id.txt_home_home1_appointment_time9);
        time10 = findViewById(R.id.txt_home_home1_appointment_time10);
        time11 = findViewById(R.id.txt_home_home1_appointment_time11);
        time12 = findViewById(R.id.txt_home_home1_appointment_time12);
        time13 = findViewById(R.id.txt_home_home1_appointment_time13);
        time14 = findViewById(R.id.txt_home_home1_appointment_time14);
        time15 = findViewById(R.id.txt_home_home1_appointment_time15);
        time16 = findViewById(R.id.txt_home_home1_appointment_time16);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        spinnerDate.setText(currentDate + " - Today");
        MyApplication.getMyApplication().getDataUser().setHomeOneDate(currentDate);
        spinnerDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final java.util.Calendar cldr = java.util.Calendar.getInstance();
                int day = cldr.get(java.util.Calendar.DAY_OF_MONTH);
                int month = cldr.get(java.util.Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                datepicker = new DatePickerDialog(TakeDateTime.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                spinnerDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                MyApplication.getMyApplication().getDataUser().setHomeOneDate(spinnerDate.getText().toString());
                            }
                        }, year, month, day);
                datepicker.show();
            }
        });

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneType(service.getText().toString());
                service.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                hService.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });
        hService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneType(hService.getText().toString());
                hService.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                service.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });
        time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time1.getText().toString());
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });
        time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time2.getText().toString());
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });

        time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time3.getText().toString());
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });
        time4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time4.getText().toString());
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });

        time5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time5.getText().toString());
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });


        time6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time6.getText().toString());
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });


        time7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time7.getText().toString());
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });


        time8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time8.getText().toString());
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });

        time9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time9.getText().toString());
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });

        time10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time10.getText().toString());
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });

        time11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time11.getText().toString());
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });

        time12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time12.getText().toString());
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });

        time13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time13.getText().toString());
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });

        time14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time14.getText().toString());
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });

        time15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time15.getText().toString());
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });

        time16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.getMyApplication().getDataUser().setHomeOneTime(time16.getText().toString());
                time16.setBackgroundTintList(ColorStateList.valueOf(0xFF2BC4BF));
                time2.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time3.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time4.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time5.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time6.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time7.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time8.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time9.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time10.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time11.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time12.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time13.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time14.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time15.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
                time1.setBackgroundTintList(ColorStateList.valueOf(0xFFECEFEF));
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( MyApplication.myApplication.getDataUser().getCheckTestAtHome().equals("1")){


                    if (MyApplication.getMyApplication().getDataUser().getHomeOneType().equals("")) {
                        Toast.makeText(TakeDateTime.this, "Please select service", Toast.LENGTH_SHORT).show();
                    } else if (MyApplication.getMyApplication().getDataUser().getHomeOneTime().equals("")) {
                        Toast.makeText(TakeDateTime.this, "Please select time for meet", Toast.LENGTH_SHORT).show();

                    } else {

                        startActivity(new Intent(getApplicationContext(), AllRelative.class));
                        finish();
                    }
                }
                else {
                    if (MyApplication.getMyApplication().getDataUser().getHomeOneType().equals("")) {
                        Toast.makeText(TakeDateTime.this, "Please select service", Toast.LENGTH_SHORT).show();
                    } else if (MyApplication.getMyApplication().getDataUser().getHomeOneTime().equals("")) {
                        Toast.makeText(TakeDateTime.this, "Please select time for meet", Toast.LENGTH_SHORT).show();

                    } else {

                        startActivity(new Intent(getApplicationContext(), CheckAll.class));
                        finish();
                    }
                }
            }
        });






    }
}