package com.smona.app.demo.evendemo;

import java.util.ArrayList;
import java.util.List;

import com.smona.app.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {
    private MyAssetGalleryFlow mMyAssetGalleryFlow = null;
    private MyAssetGalleryFlowAdapter mAdapter = null;
    private int mSelectedPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.evendemo);
        mMyAssetGalleryFlow = (MyAssetGalleryFlow) findViewById(R.id.gf_my_asset);
        mAdapter = new MyAssetGalleryFlowAdapter(this,
                new ArrayList<MyAssetGalleryFlowItem>());
        mMyAssetGalleryFlow.setAdapter(mAdapter);
        mMyAssetGalleryFlow.setOnItemSelectedListener(mOnItemSelectedListener);
        List<MyAssetGalleryFlowItem> list = new ArrayList<MyAssetGalleryFlowItem>();
        MyAssetGalleryFlowItem item = null;
        item = new MyAssetGalleryFlowItem();
        item.setAmount(0);
        item.setName("待收收益");
        list.add(item);
        item = new MyAssetGalleryFlowItem();
        item.setAmount(0);
        item.setName("总资产");
        list.add(item);
        item = new MyAssetGalleryFlowItem();
        item.setAmount(0);
        item.setName("可用资金");
        list.add(item);
        mSelectedPosition = list.size() / 2;
        mAdapter.appendToTopList(list);
        mAdapter.notifyDataSetChanged();
        mMyAssetGalleryFlow.setSelection(mSelectedPosition);
    }

    private OnItemSelectedListener mOnItemSelectedListener = new OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view,
                int position, long id) {
            mSelectedPosition = position;
            mAdapter.notifyDataSetChange(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
