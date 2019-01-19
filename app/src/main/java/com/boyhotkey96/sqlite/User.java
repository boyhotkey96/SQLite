package com.boyhotkey96.sqlite;

/**
 * Created by boyhotkey96 on 15/08/2017.
 */

public class User {
    int _id;
    String ten;

    User(String ten) {
        this.ten = ten;;
    }

    User(int _id, String ten) {
        this._id = _id;
        this.ten = ten;
    }

    /*public void set_id(int _id) {
        this._id = _id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int get_id() {
        return _id;
    }

    public String getTen() {
        return ten;
    }*/
}
