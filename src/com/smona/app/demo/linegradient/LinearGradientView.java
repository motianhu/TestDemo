package com.smona.app.demo.linegradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.LinearGradient;
import android.util.AttributeSet;
import android.view.View;

public class LinearGradientView extends View {

    private LinearGradient mLinearGradient1;
    private Paint mPaint;

    public LinearGradientView(Context context) {
        this(context, null);
    }

    public LinearGradientView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearGradientView(Context context, AttributeSet attrs,
            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mLinearGradient1 = new LinearGradient(0, 0, 0, 200, new int[] {
                Color.BLACK, Color.GRAY, 0x00ffffff }, null,
                Shader.TileMode.CLAMP);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // LinearGradient的高度只有100而绘制的矩形有200所以才会有重复
        // 如果高度两者相同clamp重复是看不出效果的
        Paint paint = new Paint();
        paint.setTextSize(20);
        paint.setColor(Color.WHITE);
        // 绘制渐变的矩形
        mPaint.setShader(mLinearGradient1);
        canvas.drawRect(0, 0, 200, 200, mPaint);
    }

}
