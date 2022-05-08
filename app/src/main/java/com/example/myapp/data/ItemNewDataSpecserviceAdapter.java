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

import java.util.List;

public class ItemNewDataSpecserviceAdapter extends RecyclerView.Adapter<ItemNewDataSpecserviceAdapter.ItemNewDataSpecserviceViewHoder> {
    List<ItemNewDataSpecservice> mListItemNewDataSpecservice;
    Context mContext1;



    public ItemNewDataSpecserviceAdapter(Context context1, List<ItemNewDataSpecservice> mListItemNewDataSpecservice) {
        this.mContext1 = context1;
        this.mListItemNewDataSpecservice = mListItemNewDataSpecservice;

    }

    @NonNull
    @Override
    public ItemNewDataSpecserviceViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spec_service, parent, false);
        return new ItemNewDataSpecserviceViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemNewDataSpecserviceViewHoder holder, @SuppressLint("RecyclerView") int position) {
        ItemNewDataSpecservice ItemNewDataSpecservice = mListItemNewDataSpecservice.get(position);

        if(ItemNewDataSpecservice==null){
            return;
        }
        holder.name.setText(ItemNewDataSpecservice.getName());

//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                List<ItemNewDataSpecservice> list = MyApplication.getMyApplication().getDataUser().getListSPECSERVICE();
//                list.remove(getAdapter)
//
//            }
//        });

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
        if(mListItemNewDataSpecservice!=null){
            return mListItemNewDataSpecservice.size();
        }
        return 0;
    }

    public class ItemNewDataSpecserviceViewHoder extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageView delete;




        public ItemNewDataSpecserviceViewHoder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_item_data_spec_service_name);
//            delete = itemView.findViewById(R.id.imv_hospital_delete);





        }
    }
}


