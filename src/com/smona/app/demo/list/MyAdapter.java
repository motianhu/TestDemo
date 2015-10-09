package com.smona.app.demo.list;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> mContent;

    public MyAdapter(ArrayList<String> content, Context context) {
        mContent = content;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mContent.size();
    }

    @Override
    public Object getItem(int position) {
        return mContent.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    android.R.layout.simple_expandable_list_item_1, null);
        }
        return convertView;
    }

}
