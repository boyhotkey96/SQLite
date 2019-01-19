package com.boyhotkey96.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by boyhotkey96 on 15/08/2017.
 */

public class MyDatabase extends SQLiteOpenHelper {

    public MyDatabase(Context context) {
        super(context, "qlcv", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table User"
        + "("
        + "_id integer primary key autoincrement,"
        + "ten text"
        + ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists User");
        onCreate(sqLiteDatabase);
    }

    public void taoUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("ten", u.ten);
        db.insert("User", null, values);
    }

    public ArrayList<User> layUser() {
        ArrayList<User> ds = new ArrayList<User>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor contro = db.rawQuery("select * from User", null);
        if (contro.moveToFirst() == true) {
            do {
                int id = Integer.parseInt(contro.getString(0));
                String ten = contro.getString(1);
                User a = new User(id, ten);
                ds.add(a);
            } while (contro.moveToNext());
        }
        return ds;
    }
}
