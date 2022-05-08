package com.example.myapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemNewDataThuoc implements Parcelable  {
    private String name, address, image, phone, ID;


    protected ItemNewDataThuoc(Parcel in) {
        name = in.readString();
        address = in.readString();
        image = in.readString();
        phone = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(image);
        dest.writeString(phone);
        dest.writeString(ID);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemNewDataThuoc> CREATOR = new Creator<ItemNewDataThuoc>() {
        @Override
        public ItemNewDataThuoc createFromParcel(Parcel in) {
            return new ItemNewDataThuoc(in);
        }

        @Override
        public ItemNewDataThuoc[] newArray(int size) {
            return new ItemNewDataThuoc[size];
        }
    };

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Creator<ItemNewDataThuoc> getCREATOR() {
        return CREATOR;
    }

    public ItemNewDataThuoc(String name, String address, String image, String phone, String ID) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.phone = phone;
        this.ID = ID;


    }


}
