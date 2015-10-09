package com.smona.app.demo.list;

import java.util.Arrays;

import com.smona.app.demo.R;
import com.smona.app.demo.common.image.ImageLoaderManager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PlusImageAdapter extends GPlusListAdapter {
    private Context context;

    public PlusImageAdapter(Context context, SpeedScrollListener scrollListener) {
        super(context, scrollListener, Arrays.asList(URLS1));
        this.context = context;
    }

    @Override
    protected View getRowView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row,
                    parent, false);

            holder = new ViewHolder();
            holder.image1 = (ImageView) convertView.findViewById(R.id.image1);
            holder.image2 = (ImageView) convertView.findViewById(R.id.image2);
            holder.image3 = (ImageView) convertView.findViewById(R.id.image3);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ImageLoaderManager.getInstance().loadImage(URLS1[position],
                holder.image1);
        ImageLoaderManager.getInstance().loadImage(URLS2[position],
                holder.image2);
        ImageLoaderManager.getInstance().loadImage(URLS3[position],
                holder.image3);

        return convertView;
    }
}
