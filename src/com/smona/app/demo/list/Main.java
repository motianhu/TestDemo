package com.smona.app.demo.list;

import com.smona.app.demo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main extends Activity implements View.OnClickListener {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list);
        findViews();
    }

    private void findViews() {
        findViewById(R.id.list).setOnClickListener(this);
        findViewById(R.id.list1).setOnClickListener(this);
        findViewById(R.id.list2).setOnClickListener(this);
        findViewById(R.id.list3).setOnClickListener(this);
        findViewById(R.id.list4).setOnClickListener(this);
        findViewById(R.id.list5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Class<?> clazz = null;
        switch (id) {
        case R.id.list:
            clazz = MyListView.class;
            break;
        case R.id.list1:
            clazz = MyListView1.class;
            break;
        case R.id.list2:
            clazz = MyListView2.class;
            break;
        case R.id.list3:
            clazz = MyListView3.class;
            break;
        case R.id.list4:
            clazz = MyListView4.class;
            break;
        case R.id.list5:
            clazz = MyListView5.class;
            break;
        }
        Intent intent = new Intent(Main.this, clazz);
        startActivity(intent);
    }
}
