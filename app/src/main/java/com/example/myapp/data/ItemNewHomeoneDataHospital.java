package com.example.myapp.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemNewHomeoneDataHospital implements Parcelable  {
    private String name, td, image, active, address, gender, phone, age, date, time, idl, ex;



    protected ItemNewHomeoneDataHospital(Parcel in) {
        name = in.readString();
        td = in.readString();
        image = in.readString();
        active = in.readString();

        address = in.readString();
        gender = in.readString();
        phone = in.readString();
        age = in.readString();
        date = in.readString();
        time = in.readString();
        idl = in.readString();
        ex = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(image);
        dest.writeString(td);
        dest.writeString(active);

        dest.writeString(address);
        dest.writeString(gender);
        dest.writeString(phone);
        dest.writeString(age);
        dest.writeString(date);
        dest.writeString(time);
        dest.writeString(idl);
        dest.writeString(ex);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemNewHomeoneDataHospital> CREATOR = new Creator<ItemNewHomeoneDataHospital>() {
        @Override
        public ItemNewHomeoneDataHospital createFromParcel(Parcel in) {
            return new ItemNewHomeoneDataHospital(in);
        }

        @Override
        public ItemNewHomeoneDataHospital[] newArray(int size) {
            return new ItemNewHomeoneDataHospital[size];
        }
    };

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTd() {
        return td;
    }

    public void setTd(String td) {
        this.td = td;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIdl() {
        return idl;
    }

    public void setIdl(String idl) {
        this.idl = idl;
    }

    public static Creator<ItemNewHomeoneDataHospital> getCREATOR() {
        return CREATOR;
    }

    public ItemNewHomeoneDataHospital(String name, String td, String image, String active, String address,
                                      String gender, String phone, String age, String date, String time,
                                      String idl, String ex) {
        this.name = name;
        this.td = td;
        this.image = image;
        this.active = active;

        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.age = age;
        this.date = date;
        this.time = time;
        this.idl = idl;
        this.ex = ex;

    }


}
