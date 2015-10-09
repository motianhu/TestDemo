package com.smona.app.demo.common.image;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class ImageLoaderManager {
    private static final String TAG = "ImageLoaderManager";
    private volatile static ImageLoaderManager sInstance;

    public synchronized static ImageLoaderManager getInstance() {
        if (sInstance == null) {
            sInstance = new ImageLoaderManager();
        }
        return sInstance;
    }

    private ImageLoaderManager() {
    }

    public void initImageLoader(Context appContext) {
        if (!(appContext instanceof Application)) {
            throw new RuntimeException("appContext is not Application Context!");
        }
        ImageLoaderConfig.initImageLoader(appContext, null);
    }

    public void loadImage(String uri, ImageView imageView) {
        ImageLoader.getInstance().displayImage(uri, imageView,
                ImageLoaderConfig.getDefaultOptions(), mImageListenser);
    }

    ImageLoadingListener mImageListenser = new ImageLoadingListener() {

        @Override
        public void onLoadingStarted(String imageUri, View view) {

        }

        @Override
        public void onLoadingFailed(String imageUri, View view,
                FailReason failReason) {
            Log.d(TAG, "onLoadingFailed onLoadingFailed imageUri: "
                    + imageUri + ", failReason: " + failReason.getCause());
        }

        @Override
        public void onLoadingComplete(String imageUri, View view,
                Bitmap loadedImage) {
        }

        @Override
        public void onLoadingCancelled(String imageUri, View view) {
            Log.d(TAG, "onLoadingCancelled onLoadingFailed imageUri: "
                    + imageUri);
        }
    };
}
