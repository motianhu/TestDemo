package com.smona.app.demo.custom;

import java.util.HashMap;

import com.smona.app.demo.custom.HorPagedView.PageSwitchListener;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class CustomPage extends LinearLayout implements PageSwitchListener {

    @SuppressLint("UseSparseArrays")
    private HashMap<Integer, Integer> mResMap = new HashMap<Integer, Integer>();

    public CustomPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setData(HashMap<Integer, Integer> resMap) {
        mResMap = resMap;
    }

    @Override
    public void onPageSwitch(View newPage, int newPageIndex) {
        Log.d("onPageSwitch", "newPage newPageIndex ;" + newPageIndex);
        int resId = mResMap.get(newPageIndex);
        if (resId > 0) {
            setBackgroundResource(resId);
        }
    }
}
