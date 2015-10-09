package com.smona.app.demo.gradient;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;

public class GradientRelativeLayout extends RelativeLayout {

    private int mWidth = 0;
    private int mHeight = 0;
    private int mBeginColorNew = 0xff460c1d;// 0xff460c1d;
    private int mEndColorNew = 0xffdf2d63;// 0xffdf2d63;
    private int mBeginColorOld = 0x00000000;
    private int mEndColorOld = 0x00000000;
    private Paint mPaintNew;
    private Paint mPaintOld;
    LinearGradient mGradientNew;
    LinearGradient mGradientOld;
    private int mAlphaNew = 255;
    // private int mAlphaOld = 0;
    private boolean mIsFirstDraw = true;
    private ValueAnimator mAnimator;
    private boolean mIsDrawColor = true;
    private Bitmap mUserBitmap = null;
    private Paint mUserPaint;
    private int mAlphaUser = 255;
    private Paint mPaintOverlap;
    private boolean mask = true;

    public GradientRelativeLayout(Context context, AttributeSet attrs,
            int defStyle) {
        super(context, attrs, defStyle);
        setWillNotDraw(false);
        initPaint();
    }

    public GradientRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        initPaint();
    }

    public GradientRelativeLayout(Context context) {
        super(context);
        setWillNotDraw(false);
        initPaint();
    }

    public void setIsDrawGradientColor(boolean isdraw) {
        mIsDrawColor = isdraw;
    }

    public void setColor(int begin, int end) {
        if (begin == 0 || end == 0) {
            return;
        }
        mBeginColorOld = mBeginColorNew;
        mEndColorOld = mEndColorNew;
        mBeginColorNew = begin;
        mEndColorNew = end;
        if (!mIsFirstDraw) {
            initLinearGradient();
            invalidate();
            startAnim();
        }
    }

    public void setDegree(int degree) {
        invalidate();
    }

    public void setMask(boolean mask) {
        this.mask = mask;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            if (!mIsDrawColor) {
                if (mUserBitmap != null) {
                    initPaintParam();
                    canvas.drawRect(0, 0, mWidth, mHeight, mPaintNew);
                    mUserPaint.setAlpha(mAlphaUser);
                    if (mUserBitmap.isRecycled() == false) {
                        RectF rectF = new RectF(0, 0, mWidth, mHeight);
                        // canvas.drawBitmap(mUserBitmap, 0, 0, mUserPaint);
                        canvas.drawBitmap(mUserBitmap, null, rectF, mUserPaint);
                    }
                }
                if (mask) {
                    mPaintOverlap.setAlpha(mAlphaUser / 2);
                    canvas.drawRect(0, 0, mWidth, mHeight, mPaintOverlap);
                }
                return;
            }
            if (mIsFirstDraw) {
                initLinearGradient();
                mIsFirstDraw = false;
            }
            initPaintParam();
            canvas.drawRect(0, 0, mWidth, mHeight, mPaintOld);
            canvas.drawRect(0, 0, mWidth, mHeight, mPaintNew);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("motianhu",
                    "draw GradientRelativeLayout occur exception, e == "
                            + e.toString());
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        initLinearGradient();
    }

    private void initPaint() {
        mPaintNew = new Paint();
        mPaintOld = new Paint();
        mUserPaint = new Paint();
        mPaintOverlap = new Paint();
        mPaintOverlap.setColor(0x80000000);
    }

    private void initPaintParam() {
        mPaintNew.setShader(mGradientNew);
        mPaintNew.setAlpha(mAlphaNew);
        mPaintOld.setShader(mGradientOld);
        // mPaintOld.setAlpha(mAlphaOld);
    }

    private void startAnim() {
        endAnim();
        mAnimator = ValueAnimator.ofInt(0, 255);
        mAnimator.setDuration(800);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.addUpdateListener(new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator value) {
                mAlphaNew = (Integer) value.getAnimatedValue();
                // mAlphaOld = 255 - mAlphaNew;
                invalidate();
            }
        });
        mAnimator.start();
    }

    private void initLinearGradient() {
        mGradientNew = new LinearGradient(mWidth, mHeight, 0, 0,
                mBeginColorNew, mEndColorNew, Shader.TileMode.MIRROR);
        mGradientOld = new LinearGradient(mWidth, mHeight, 0, 0,
                mBeginColorOld, mEndColorOld, Shader.TileMode.MIRROR);
    }

    private void endAnim() {
        if (mAnimator != null) {
            mAnimator.end();
            mAnimator = null;
        }
    }

    public void setUserBackground(Bitmap bitmap) {
        mUserBitmap = bitmap;
        startUserBitmapAnim();
    }

    private void startUserBitmapAnim() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 255);
        animator.setDuration(3000);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator value) {
                int val = (Integer) value.getAnimatedValue();
                mAlphaUser = val;
                invalidate();
            }
        });
        animator.start();
    }
}
