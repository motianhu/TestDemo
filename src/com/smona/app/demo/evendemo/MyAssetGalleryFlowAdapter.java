/**
 * Title: MyAssetGalleryFlowAdapter.java
 * Description: 
 * Copyright: Copyright (c) 2013-2015 luoxudong.com
 * Company: 个人
 * Author: 罗旭东 (hi@luoxudong.com)
 * Date: 2015年8月31日 下午6:51:00
 * Version: 1.0
 */
package com.smona.app.demo.evendemo;

import java.util.List;

import com.smona.app.demo.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * <pre>
 * ClassName: MyAssetGalleryFlowAdapter
 * Description:TODO(这里用一句话描述这个类的作用)
 * Create by: 罗旭东
 * Date: 2015年8月31日 下午6:51:00
 * </pre>
 */
public class MyAssetGalleryFlowAdapter extends
        AbsBaseAdapter<MyAssetGalleryFlowItem> {

    public MyAssetGalleryFlowAdapter(Context context,
            List<MyAssetGalleryFlowItem> list) {
        super(context, list);
    }

    @Override
    protected View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(
                    R.layout.layout_my_asset_gallery_flow_item, null);
            viewHolder.mNameTextView = (TextView) convertView
                    .findViewById(R.id.tv_name);
            viewHolder.mAmountTextView = (TextView) convertView
                    .findViewById(R.id.tv_amount);
            viewHolder.mDetailTextView = (TextView) convertView
                    .findViewById(R.id.tv_detail);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        MyAssetGalleryFlowItem item = getItem(position);
        viewHolder.mNameTextView.setText(item.getName());
        if (item.getAmount() < 0) {
            viewHolder.mAmountTextView.setText("----");
        } else {
            viewHolder.mAmountTextView.setText(MoneyUtil
                    .formatMoneyThousHold(item.getAmount()));
        }
        viewHolder.mDetailTextView.setText(item.getDetail());
        return convertView;
    }

    public void notifyDataSetChange(int position) {
        super.notifyDataSetChanged();
    }

    public class ViewHolder {
        public TextView mNameTextView = null;
        public TextView mAmountTextView = null;
        public TextView mDetailTextView = null;
    }

}
