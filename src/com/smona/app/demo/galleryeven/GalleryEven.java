package com.smona.app.demo.galleryeven;

import com.smona.app.demo.R;

import android.app.Activity;
import android.os.Bundle;

public class GalleryEven extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galleryeven);

        int[] resids = new int[] { R.drawable.my_asset_gallery_flow_item_bg,
                R.drawable.my_asset_gallery_flow_item_bg,
                R.drawable.my_asset_gallery_flow_item_bg };
        ImageAdapter imageAdapter = new ImageAdapter(this, resids);

        // gallery.setAdapter(imageAdapter);
        // gallery.setSelection(Integer.MAX_VALUE / 2);
        //

        int space = this.getResources().getDimensionPixelSize(
                R.dimen.covet_flow_space);
        FancyCoverFlow fancyCoverFlow = (FancyCoverFlow) this
                .findViewById(R.id.home_recommend);
        fancyCoverFlow.setAdapter(imageAdapter);
        fancyCoverFlow.setUnselectedAlpha(1.0f);
        fancyCoverFlow.setUnselectedSaturation(0.0f);
        fancyCoverFlow.setUnselectedScale(0.5f);
        fancyCoverFlow.setSpacing(-space);
        fancyCoverFlow.setMaxRotation(0);
        fancyCoverFlow.setScaleDownGravity(0.2f);
        fancyCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
        fancyCoverFlow.setSelection(Integer.MAX_VALUE / 2);
    }
}
