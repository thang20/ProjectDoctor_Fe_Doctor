package com.example.myapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;

import java.util.List;

public class ItemNewDataAdddrugAdapter extends RecyclerView.Adapter<ItemNewDataAdddrugAdapter.ItemNewDataAdddrugViewHoder> {
    List<ItemNewDataAdddrug> mListItemNewDataAdddrug;
    Context mContext1;



    public ItemNewDataAdddrugAdapter(Context context1, List<ItemNewDataAdddrug> mListItemNewDataAdddrug) {
        this.mContext1 = context1;
        this.mListItemNewDataAdddrug = mListItemNewDataAdddrug;

    }

    @NonNull
    @Override
    public ItemNewDataAdddrugViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spec_add_dr, parent, false);
        return new ItemNewDataAdddrugViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemNewDataAdddrugViewHoder holder, @SuppressLint("RecyclerView") int position) {
        ItemNewDataAdddrug ItemNewDataAdddrug = mListItemNewDataAdddrug.get(position);

        if(ItemNewDataAdddrug==null){
            return;
        }
        holder.name.setText(ItemNewDataAdddrug.getName());
        holder.number.setText(ItemNewDataAdddrug.getNumber());

//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                List<ItemNewDataAdddrug> list = MyApplication.getMyApplication().getDataUser().getListSPECSERVICE();
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
        if(mListItemNewDataAdddrug!=null){
            return mListItemNewDataAdddrug.size();
        }
        return 0;
    }

    public class ItemNewDataAdddrugViewHoder extends RecyclerView.ViewHolder{
        private TextView name, number;




        public ItemNewDataAdddrugViewHoder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_item_data_drug_name);
            number = itemView.findViewById(R.id.txt_item_data_drug_name_number);
//            delete = itemView.findViewById(R.id.imv_hospital_delete);





        }
    }
}



