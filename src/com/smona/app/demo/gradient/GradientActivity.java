package com.smona.app.demo.gradient;

import com.smona.app.demo.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class GradientActivity extends Activity {
    private static final String TAG = "MusicBaseActivity";
    private AlertDialog mDialog;
    private static String IDLE_ACTION = "music.VolumeSeekBarView.isidle";
    private static String TOUCH_UP_WHEN_MAXVOLUME_ACTION = "music.VolumeSeekBarView.touchup.maxvolume";
    private static String REMOVE_TIMEOUT_ACTION = "music.VolumeSeekBarView.remove.timeout";
    private BroadcastReceiver mScreenOffReceiver;
    private BroadcastReceiver mSeekBarAnimatorEndBroadcast;
    private BroadcastReceiver mTouchUpMaxVolumeBroadcast;
    private BroadcastReceiver mRemoveTimeoutBroadcast;
    protected GradientRelativeLayout mLayout;

    private BroadcastReceiver mColorChangedBroadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context arg0, Intent arg1) {
            refreshBgColor();
        }
    };

    public void refreshFeedback() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gradient);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected void setLayotMask(boolean mask) {
        mLayout.setMask(mask);
    }

    public void setBackground() {
        try {
            if (mLayout == null)
                return;
            BitmapDrawable drawable = null;// app.getBgService().getBgDrawable();
            if (drawable != null) {
                mLayout.setIsDrawGradientColor(false);
                mLayout.setBackgroundDrawable(drawable);
            } else {
                mLayout.setBackgroundColor(0x00554545);
                mLayout.setIsDrawGradientColor(true);
                refreshBgColor();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        try {
            super.setContentView(R.layout.gradient_root);
            mLayout = (GradientRelativeLayout) findViewById(R.id.musicbaselayout);
            setBackground();
            LayoutInflater mInflater = LayoutInflater.from(this);
            View view = mInflater.inflate(layoutResID, null);
            mLayout.addView(view);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void refreshBgColor() {
        int sc = 0;// GnMusicApp.getInstance().getStartColor();
        int ec = 20;// GnMusicApp.getInstance().getEndColor();
        if (mLayout != null) {
            mLayout.setColor(sc, ec);
        }
    }
}
