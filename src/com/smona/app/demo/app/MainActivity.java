package com.smona.app.demo.app;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppInfo app = new AppInfo();
        app.print(this);
        app.print(this, "duz.qod.bcdkq");
    }
}
