package com.example.myapp.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.MyApplication;
import com.example.myapp.R;
import com.example.myapp.home.InforService;

import java.util.List;

public class ItemNewExAdapter extends RecyclerView.Adapter<ItemNewExAdapter.ItemNewExViewHoder> {
    List<ItemNewEx> mListItemNewEx;
    Context mContext1;



    public ItemNewExAdapter(Context context1, List<ItemNewEx> mListItemNewEx) {
        this.mContext1 = context1;
        this.mListItemNewEx = mListItemNewEx;


    }

    @NonNull
    @Override
    public ItemNewExViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item_ex_d, parent, false);
        return new ItemNewExViewHoder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemNewExViewHoder holder, @SuppressLint("RecyclerView") int position) {
        ItemNewEx ItemNewEx = mListItemNewEx.get(position);

        if(ItemNewEx==null){
            return;
        }
        holder.name.setText(ItemNewEx.getName());

        holder.editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String check = holder.editText.getText().toString();
                if(check.length()>0){
                    MyApplication.myApplication.getDataUser().setBenhnhanThuoc(MyApplication.getMyApplication().getDataUser().getBenhnhanThuoc()+check+"-");
                    Log.d("111", MyApplication.getMyApplication().getDataUser().getBenhnhanThuoc());
                }
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
        if(mListItemNewEx!=null){
            return mListItemNewEx.size();
        }
        return 0;
    }

    public class ItemNewExViewHoder extends RecyclerView.ViewHolder{
        private TextView name;
        private EditText editText;





        public ItemNewExViewHoder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_ex_d);
            editText = itemView.findViewById(R.id.edt_profile_update_fullName);




        }
    }
}


