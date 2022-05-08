package com.example.myapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemNewEx implements Parcelable  {
    private String name;



    protected ItemNewEx(Parcel in) {
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

    public static final Creator<ItemNewEx> CREATOR = new Creator<ItemNewEx>() {
        @Override
        public ItemNewEx createFromParcel(Parcel in) {
            return new ItemNewEx(in);
        }

        @Override
        public ItemNewEx[] newArray(int size) {
            return new ItemNewEx[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Creator<ItemNewEx> getCREATOR() {
        return CREATOR;
    }

    public ItemNewEx(String name) {
        this.name = name;


    }


}
