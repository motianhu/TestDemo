/**
 * Title: MyAssetGalleryFlow.java
 * Description: 
 * Copyright: Copyright (c) 2013-2015 luoxudong.com
 * Company: 个人
 * Author: 罗旭东 (hi@luoxudong.com)
 * Date: 2015年8月31日 下午6:42:51
 * Version: 1.0
 */
package com.smona.app.demo.evendemo;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;

/**
 * <pre>
 * ClassName: MyAssetGalleryFlow
 * Description:TODO(这里用一句话描述这个类的作用)
 * Create by: 罗旭东
 * Date: 2015年8月31日 下午6:42:51
 * </pre>
 */
public class MyAssetGalleryFlow extends Gallery {
    private Camera mCamera = new Camera();
    private int mMaxRotationAngle = 60;
    private int mMaxZoom = -120;
    private int mCoveflowCenter;

    public MyAssetGalleryFlow(Context context) {
        this(context, null);
    }

    public MyAssetGalleryFlow(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyAssetGalleryFlow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setStaticTransformationsEnabled(true);
    }

    public int getMaxRotationAngle() {
        return mMaxRotationAngle;
    }

    public void setMaxRotationAngle(int maxRotationAngle) {
        mMaxRotationAngle = maxRotationAngle;
    }

    public int getMaxZoom() {
        return mMaxZoom;
    }

    public void setMaxZoom(int maxZoom) {
        mMaxZoom = maxZoom;
    }

    private int getCenterOfCoverflow() {
        return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2
                + getPaddingLeft();
    }

    private static int getCenterOfView(View view) {
        return view.getLeft() + view.getWidth() / 2;
    }

    protected boolean getChildStaticTransformation(View child, Transformation t) {

        final int childCenter = getCenterOfView(child);
        final int childWidth = child.getWidth();
        int rotationAngle = 0;

        t.clear();
        t.setTransformationType(Transformation.TYPE_MATRIX);
        Log.v("tag",
                "getChildStaticTransformation>>>>>>>>>>>>>>>>>>>childCenter"
                        + childCenter
                        + ">>>>>"
                        + Math.abs((mCoveflowCenter - childCenter)
                                / (childWidth)));
        if (childCenter == mCoveflowCenter) {
            transformImageBitmap(child, t, 0);
        } else {
            if ((mCoveflowCenter - childCenter) > 0) {
                rotationAngle = (int) mMaxRotationAngle;
            } else {
                rotationAngle = (int) -mMaxRotationAngle;
            }
            if (Math.abs((mCoveflowCenter - childCenter) / (childWidth / 2)) == 0) {
                rotationAngle = (int) (((float) (mCoveflowCenter - childCenter) / childWidth) * mMaxRotationAngle);
            }

            transformImageBitmap(child, t, rotationAngle);
        }

        return true;
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mCoveflowCenter = getCenterOfCoverflow();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    private void transformImageBitmap(View child, Transformation t,
            int rotationAngle) {
        mCamera.save();
        final Matrix imageMatrix = t.getMatrix();
        final int imageHeight = child.getLayoutParams().height;
        final int imageWidth = child.getLayoutParams().width;
        final int rotation = Math.abs(rotationAngle);

        // 在Z轴上正向移动camera的视角，实际效果为放大图片。
        // 如果在Y轴上移动，则图片上下移动；X轴上对应图片左右移动。
        mCamera.translate(0.0f, 0.0f, 100.0f);

        // // As the angle of the view gets less, zoom in
        // if (rotation < mMaxRotationAngle) {
        // float zoomAmount = (float) (mMaxZoom + (rotation * 1.5));
        // mCamera.translate(0.0f, 0.0f, zoomAmount);
        // }

        // 在Y轴上旋转，对应图片竖向向里翻转。
        // 如果在X轴上旋转，则对应图片横向向里翻转。
        mCamera.rotateY(rotationAngle);
        mCamera.getMatrix(imageMatrix);
        imageMatrix.preTranslate(-(imageWidth / 2), -(imageHeight / 2));
        imageMatrix.postTranslate((imageWidth / 2), (imageHeight / 2));
        mCamera.restore();
    }
}
