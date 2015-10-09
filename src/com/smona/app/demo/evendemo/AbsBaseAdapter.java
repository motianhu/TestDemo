/**
 * Title: AbsBaseAdapter.java
 * Description:
 * Copyright: Copyright (c) 2013 luoxudong.com
 * Company:个人
 * Author 罗旭东 (hi@luoxudong.com)
 * Date 2013-8-14 上午9:24:17
 * Version 1.0 
 */
package com.smona.app.demo.evendemo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * ClassName: AbsBaseAdapter Description:activity中adapter的抽象基类 Create by 罗旭东
 * Date 2013-8-14 上午9:24:17
 */
public abstract class AbsBaseAdapter<T> extends BaseAdapter {
    /** 内容 */
    protected List<T> mDataList = null;

    /** 上下文 */
    protected Context mContext = null;

    /** 布局 */
    protected LayoutInflater mInflater = null;

    public AbsBaseAdapter(Context context, List<T> list) {
        mContext = context;
        mDataList = list;

        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 
     * @description:设置内容
     * @param list
     *            内容list
     * @throws
     */
    public void setList(List<T> list) {
        mDataList = list;
    }

    /**
     * 
     * @description: 获取内容
     * @return 内容list
     * @throws
     */
    public List<T> getList() {
        return mDataList;
    }

    /**
     * 
     * @description:在开始位置添加内容
     * @param list
     *            需要添加的内容
     * @throws
     */
    public void appendToBottomList(List<T> list) {
        if (list == null) {
            return;
        }

        if (mDataList == null) {
            mDataList = new ArrayList<T>();
        }

        mDataList.addAll(list);
        // notifyDataSetChanged();
    }

    /**
     * 
     * @description:在尾部添加内容
     * @param list
     * @throws
     */
    public void appendToTopList(List<T> list) {
        if (list == null) {
            return;
        }

        if (mDataList == null) {
            mDataList = new ArrayList<T>();
        }

        mDataList.addAll(0, list);
        // notifyDataSetChanged();
    }

    /**
     * 
     * @description:清除内容
     * @throws
     */
    public void clear() {

        if (mDataList == null) {
            return;
        }

        mDataList.clear();
        // notifyDataSetChanged();
    }

    @Override
    public int getCount() {

        if (mDataList == null) {
            return 0;
        }

        return mDataList.size();
    }

    @Override
    public T getItem(int position) {
        if (mDataList == null || (position > mDataList.size() - 1)) {
            return null;
        }

        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItemView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return super.getDropDownView(position, convertView, parent);
    }

    protected abstract View getItemView(int position, View convertView,
            ViewGroup parent);
}
