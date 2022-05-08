package com.example.myapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemNewDataSpecservice implements Parcelable  {
    private String name;


    protected ItemNewDataSpecservice(Parcel in) {
        name = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);


    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemNewDataSpecservice> CREATOR = new Creator<ItemNewDataSpecservice>() {
        @Override
        public ItemNewDataSpecservice createFromParcel(Parcel in) {
            return new ItemNewDataSpecservice(in);
        }

        @Override
        public ItemNewDataSpecservice[] newArray(int size) {
            return new ItemNewDataSpecservice[size];
        }
    };



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static Creator<ItemNewDataSpecservice> getCREATOR() {
        return CREATOR;
    }

    public ItemNewDataSpecservice(String name) {
        this.name = name;
    }


}
