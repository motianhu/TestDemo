package com.smona.app.demo.crop;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.smona.app.demo.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class CropActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.crop);
        findViewById(R.id.crop).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String sdcard = Environment.getExternalStorageDirectory()
                        .getAbsolutePath();
                sdcard = "girl_1080_1920.jpg";
                try {
                    getBitmapFromFile(sdcard);
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("motianhu", "file: " + e);
                }
            }

        });
    }

    public static void saveBitmap(Bitmap bitmap, String path) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("motianhu", "saveBitmap: " + path + "; e: " + path);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void getBitmapFromFile(String file) throws IOException {
        Log.d("motianhu", "file: " + file);
        // Bitmap srcBitmap = BitmapFactory.decodeFile(file);

        InputStream is = getResources().getAssets().open(file);
        Bitmap srcBitmap = BitmapFactory.decodeStream(is);
        Log.d("motianhu", "srcBitmap: " + srcBitmap);
        int srcWidth = srcBitmap.getWidth();
        int srcHeight = srcBitmap.getHeight();

        int targetW = 350;
        int targetH = 622;

        float scaleWidth = ((float) targetW) / srcWidth;
        float scaleHeight = ((float) targetH) / srcHeight;

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap result = Bitmap.createBitmap(srcBitmap, 0, 0, srcWidth,
                srcHeight, matrix, true);
        String sdcard = Environment.getExternalStorageDirectory()
                .getAbsolutePath();
        sdcard += "/girl_" + targetW + "_" + targetH + ".jpg";
        saveBitmap(result, sdcard);
    }
}
