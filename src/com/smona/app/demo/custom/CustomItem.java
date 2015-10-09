package com.smona.app.demo.custom;

import com.smona.app.demo.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class CustomItem extends RelativeLayout {

    private ImageView mImage;
    private View mAlphaView;

    public CustomItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mImage = (ImageView) findViewById(R.id.image);
        mAlphaView = findViewById(R.id.alphaView);
    }

    public void setImageResource(int resId) {
        mImage.setImageResource(resId);
    }

    public void setAlpha(float alpha) {
        mAlphaView.setAlpha(alpha);
    }
}
