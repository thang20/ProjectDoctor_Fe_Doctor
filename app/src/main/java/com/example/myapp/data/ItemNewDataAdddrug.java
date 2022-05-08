package com.example.myapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemNewDataAdddrug implements Parcelable  {
    private String name, number;


    protected ItemNewDataAdddrug(Parcel in) {
        name = in.readString();
        number = in.readString();


    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(number);


    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemNewDataAdddrug> CREATOR = new Creator<ItemNewDataAdddrug>() {
        @Override
        public ItemNewDataAdddrug createFromParcel(Parcel in) {
            return new ItemNewDataAdddrug(in);
        }

        @Override
        public ItemNewDataAdddrug[] newArray(int size) {
            return new ItemNewDataAdddrug[size];
        }
    };



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static Creator<ItemNewDataAdddrug> getCREATOR() {
        return CREATOR;
    }

    public ItemNewDataAdddrug(String name, String number) {

        this.name = name;
        this.number = number;
    }


}
