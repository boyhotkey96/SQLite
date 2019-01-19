package com.boyhotkey96.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> ds = new ArrayList<User>();
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);

        MyDatabase db = new MyDatabase(MainActivity.this);
        db.taoUser(new User("Le Van Tam"));
        db.taoUser(new User("Tran Van Bon"));
        db.taoUser(new User("Tran Thi Chin"));

        ds = db.layUser();
        for (int i = 0; i <= ds.size(); i++) {
            tv.append(ds.get(i).ten + "\n");
        }
    }
}
