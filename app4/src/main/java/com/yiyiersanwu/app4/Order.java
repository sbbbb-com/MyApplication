package com.yiyiersanwu.app4;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * 订单类
 */
public class Order implements Parcelable {
    private  String id;
    private  String address;
    private  int count;

    public Order(String id, String address, int count) {
        this.id = id;
        this.address = address;
        this.count = count;
    }

    public Order() {
    }

    protected Order(Parcel in) {
        id = in.readString();
        address = in.readString();
        count = in.readInt();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", count=" + count +
                '}';
    }

    //内容描述
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(address);
        dest.writeInt(count);
    }
}
