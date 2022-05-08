package com.example.myapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.hospital.LocationHospital;

import java.util.List;

public class ItemNewDataThuocAdapter extends RecyclerView.Adapter<ItemNewDataThuocAdapter.ItemNewDataThuocViewHoder> {
    List<ItemNewDataThuoc> mListItemNewDataThuoc;
    Context mContext1;



    public ItemNewDataThuocAdapter(Context context1, List<ItemNewDataThuoc> mListItemNewDataThuoc) {
        this.mContext1 = context1;
        this.mListItemNewDataThuoc = mListItemNewDataThuoc;

    }

    @NonNull
    @Override
    public ItemNewDataThuocViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thuoc_data, parent, false);
        return new ItemNewDataThuocViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemNewDataThuocViewHoder holder, @SuppressLint("RecyclerView") int position) {
        ItemNewDataThuoc ItemNewDataThuoc = mListItemNewDataThuoc.get(position);

        if(ItemNewDataThuoc==null){
            return;
        }
        holder.name.setText(ItemNewDataThuoc.getName());
        holder.address.setText(ItemNewDataThuoc.getAddress());
        holder.phone.setText(ItemNewDataThuoc.getPhone());
        holder.ID.setText(ItemNewDataThuoc.getID());
        Glide.with(mContext1).load(MyApplication.getMyApplication().getDataUser().getAPI()+ItemNewDataThuoc.getImage()).into(holder.image);

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = ItemNewDataThuoc.getPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                mContext1.startActivity(intent);

            }
        });


//        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {

//                Log.d("100", String.valueOf(position));
//
//                JSONObject jsonObject = new JSONObject();
//                String jsonStr = null;
//                try {
//                    String email = MyApplication.getMyApplication().getDataUser().getEmailStatic();
//                    jsonObject = new JSONObject();
//                    jsonObject.put("email", email);
//                    jsonObject.put("position", String.valueOf(position));
//                    jsonStr = jsonObject.toString();
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                RequestBody body =
//                        RequestBody.create(MediaType.parse("text/plain"), jsonStr);
//
//                Apiservice.apiservice.profilescheduledelete(body).enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//                        String notice = null;
//
//                        try {
//                            notice = response.body().string();
//                            if(notice.equals("success")){
//                                Toast.makeText(view.getContext(), "Success", Toast.LENGTH_LONG).show();
//                                mContext1.startActivity(new Intent(view.getContext(), ProfileDataSchedule.class));
//
//                            }else {
//                                Toast.makeText(view.getContext(), "Fail to Delete", Toast.LENGTH_LONG).show();
//                            }
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Toast.makeText(view.getContext(), "Fail to call API", Toast.LENGTH_LONG).show();
//
//                    }
//                });
//            }
//        });
    }

    public void release(){
        mContext1 = null;
    }
    @Override
    public int getItemCount() {
        if(mListItemNewDataThuoc!=null){
            return mListItemNewDataThuoc.size();
        }
        return 0;
    }

    public class ItemNewDataThuocViewHoder extends RecyclerView.ViewHolder{
        private TextView name, address, phone, ID;
        private ImageView image;
        private Button call;




        public ItemNewDataThuocViewHoder(@NonNull View itemView) {
            super(itemView);
            ID = itemView.findViewById(R.id.txt_home_home3_doctor_ID);
            name = itemView.findViewById(R.id.txt_home_home3_doctor_name);
            address = itemView.findViewById(R.id.txt_home_home3_doctor_address);
            phone = itemView.findViewById(R.id.txt_home_home3_doctor_phone);
            image = itemView.findViewById(R.id.imv_home_home3_doctor_toa);
            call = itemView.findViewById(R.id.btn_home_home3_doctor_next);




        }
    }
}

