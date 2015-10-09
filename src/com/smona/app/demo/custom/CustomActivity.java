package com.smona.app.demo.custom;

import java.util.HashMap;

import com.smona.app.demo.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class CustomActivity extends Activity {

    @SuppressLint("UseSparseArrays")
    private HashMap<Integer, Integer> mResMap = new HashMap<Integer, Integer>();
    private static final int PageCount = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom);
        initData();
        initChange();
        initRoot();
        getNumber();
    }

    private void getNumber() {
        TelephonyManager tm = (TelephonyManager) this
                .getSystemService(Context.TELEPHONY_SERVICE);
        String deviceid = tm.getDeviceId();
        String te1 = tm.getLine1Number();
        String imei = tm.getSimSerialNumber();
        String imsi = tm.getSubscriberId();
        Log.e("te1", "te1:" + te1 + ", imei: " + imei + ", imsi: " + imsi
                + ", deviceid: " + deviceid);

    }

    private void initData() {
        int x = 0;
        int resId = 0;
        for (int i = 0; i < PageCount; i++) {
            x = i % 4;
            switch (x) {
            case 0:
                resId = R.drawable.wallpaper03;
                break;
            case 1:
                resId = R.drawable.wallpaper01;
                break;
            case 2:
                resId = R.drawable.wallpaper02;
                break;
            case 3:
                resId = R.drawable.wallpaper00;
                break;
            }
            mResMap.put(i, resId);
        }
    }

    private void initChange() {
        CustomPage background = (CustomPage) findViewById(R.id.root);
        background.setData(mResMap);
        background.setBackgroundResource(R.drawable.wallpaper00);

        View transport = findViewById(R.id.transport_layer);
        transport.setBackgroundResource(R.drawable.middle);

        PicturePage view = (PicturePage) findViewById(R.id.pagedview);
        initPage(view);
        view.changeState(PicturePage.State.NORMAL, 0);
        view.setPageSwitchListener(background);
    }

    private void initRoot() {

    }

    private void initPage(ViewGroup parent) {
        for (int i = 0; i < PageCount; i++) {
            addViews(parent, mResMap.get(i));
        }
    }

    @SuppressLint("InflateParams")
    private void addViews(ViewGroup parent, int resId) {
        CustomItem appPage = (CustomItem) LayoutInflater.from(this).inflate(
                R.layout.custom_item, null);
        appPage.setImageResource(resId);
        int childW = this.getResources().getDimensionPixelSize(R.dimen.custom_container_width);
        int childH = this.getResources().getDimensionPixelSize(R.dimen.custom_container_height);
        LayoutParams params = new LayoutParams(childW, childH);
        parent.addView(appPage, params);
    }

    /**
     * gridView 的onItemLick响应事件
     */
    public OnItemClickListener listener = new OnItemClickListener() {

        public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) {
            System.out.println("position=" + position);
        }

    };

    @Override
    protected void onDestroy() {
        android.os.Process.killProcess(android.os.Process.myPid());
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
