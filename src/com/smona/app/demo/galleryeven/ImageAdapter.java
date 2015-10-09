package com.smona.app.demo.galleryeven;

import com.smona.app.demo.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter extends FancyCoverFlowAdapter {

    private int[] mResIds = null;
    private Context mContext;

    public ImageAdapter(Context context, int[] resIds) {
        mContext = context;
        mResIds = resIds;
    }

    public int getCount() {
        return Integer.MAX_VALUE;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getCoverFlowItem(int position, View reusableView,
            ViewGroup parent) {
        ImageView imageView = null;
        if (reusableView != null) {
            imageView = (ImageView) reusableView;
        } else {
            imageView = new ImageView(parent.getContext());
            int w = mContext.getResources().getDimensionPixelSize(
                    R.dimen.covet_flow_child_w);
            int h = mContext.getResources().getDimensionPixelSize(
                    R.dimen.covet_flow_child_h);
            imageView.setLayoutParams(new FancyCoverFlow.LayoutParams(w, h));
        }
        imageView.setImageResource(mResIds[position % mResIds.length]);
        return imageView;
    }

}
