package com.example.myapp.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.carepaynonactive_interface.CheckFace;
import com.example.myapp.carepaynonactive_interface.IDCard;
import com.example.myapp.profile_interface.UpdateProfile;

import java.util.ArrayList;

public class IdentityActiveDoctor extends AppCompatActivity {
    ImageView back;
    TextView phone, name;
    Button update, comtinue;
    Spinner typehospital, typespec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity_active_doctor);

        back = findViewById(R.id.imv_avtive_doctor_non_cardid_back);
        phone = findViewById(R.id.txt_avtive_doctor_non_cardid_phone);
        name = findViewById(R.id.txt_avtive_doctor_non_cardid_name);
        update = findViewById(R.id.btn_avtive_doctor_non_cardid_update);
        typehospital = findViewById(R.id.sql_avtive_doctor_non_cardid_typecard);
        typespec = findViewById(R.id.edt_avtive_doctor_doctor_non_cardid_numberid);
        comtinue = findViewById(R.id.btn_avtive_doctor_non_cardid_next);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        phone.setText(MyApplication.getMyApplication().getDataUser().getPhoneStatic());
        name.setText(MyApplication.getMyApplication().getDataUser().getFullNameStatic());
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("National Lung Hospital");
        arrayList.add("Hanoi Medical University Hospital");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typehospital.setAdapter(arrayAdapter);
        MyApplication.getMyApplication().getDataUser().setDoctorhospital(typehospital.getSelectedItem().toString());

        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("On-demand examination");
        arrayList1.add("Vaccination consultation");
        arrayList1.add("Cardiology examination");
        arrayList1.add("Cancer examination");
        arrayList1.add("Urology examination");
        arrayList1.add("Outpatient examination/outpatient");
        arrayList1.add("Therapeutic materials");
        arrayList1.add("Internal examination");
        arrayList1.add("Cancer resistance test");
        arrayList1.add("Oriental medicine examination");
        arrayList1.add("Eye exam");
        arrayList1.add("General examination");
        arrayList1.add("Dental visit");
        arrayList1.add("Obstetric/Gynecological Examination");
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList1);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typespec.setAdapter(arrayAdapter1);
        MyApplication.getMyApplication().getDataUser().setDoctorspec(typespec.getSelectedItem().toString());


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IdentityActiveDoctor.this, UpdateProfile.class);
                MyApplication.getMyApplication().getDataUser().setActivedoctor(true);
                MyApplication.getMyApplication().getDataUser().setCarepay(false);
                startActivity(intent);
                finish();
            }
        });


        comtinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    MyApplication.getMyApplication().getDataUser().setActivedoctortoface(true);
                    MyApplication.getMyApplication().getDataUser().setCarepaytoface(false);

                    Intent intent = new Intent(IdentityActiveDoctor.this, CheckFace.class);
                    startActivity(intent);
                    //MyApplication.getMyApplication().getDataUser().setIdcard(idnumber.getText().toString());
                    finish();
            }
        });
    }
}