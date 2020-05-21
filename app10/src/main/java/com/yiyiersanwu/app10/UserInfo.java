package com.yiyiersanwu.app10;

import java.util.zip.Deflater;

public class UserInfo {
    private int id;
    private String name;
    private String phone;
    private Boolean isChecked;

    public Boolean isChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        this.isChecked = checked;
    }

    public UserInfo() {
    }

    public UserInfo(int id, String name, String phone,Boolean isChecked) {
        this.id = id;
        this.name = name;
        this.phone = phone;

    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
