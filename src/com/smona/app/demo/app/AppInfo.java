package com.smona.app.demo.app;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.util.Log;

public class AppInfo {
    @SuppressLint("NewApi")
    public void print(Context context) {
        PackageManager packageManager = context.getPackageManager();
        final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> apps = packageManager.queryIntentActivities(
                mainIntent, 0);
        for (ResolveInfo app : apps) {
            Log.d("motianhu", app.activityInfo.packageName + ";  app: "
                    + app.activityInfo.applicationInfo.publicSourceDir);
        }
    }

    public void print(Context context, String pkgName) {
        PackageManager pm = context.getPackageManager();
        String name = null;
        try {
            name = pm.getApplicationLabel(
                    pm.getApplicationInfo(pkgName,
                            PackageManager.GET_META_DATA)).toString();
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        Log.d("motianhu", name + ";  app: " + pkgName);
    }
}
