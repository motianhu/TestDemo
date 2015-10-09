package com.smona.app.demo.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private int[] mResIds = null;

    public ImageAdapter(Context context, int[] resIds) {
        mContext = context;
        mResIds = resIds;
    }

    public int getCount() {
        return mResIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView image = new ImageView(mContext);
        image.setImageResource(mResIds[position]);
        image.setAdjustViewBounds(true);
        image.setLayoutParams(new Gallery.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        return image;
    }

}
