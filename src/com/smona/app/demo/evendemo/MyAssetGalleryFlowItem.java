/**
 * Title: MyAssetGalleryFlowItem.java
 * Description: 
 * Copyright: Copyright (c) 2013-2015 luoxudong.com
 * Company: 个人
 * Author: 罗旭东 (hi@luoxudong.com)
 * Date: 2015年8月31日 下午7:01:04
 * Version: 1.0
 */
package com.smona.app.demo.evendemo;

import java.io.Serializable;

/**
 * <pre>
 * ClassName: MyAssetGalleryFlowItem
 * Description:TODO(这里用一句话描述这个类的作用)
 * Create by: 罗旭东
 * Date: 2015年8月31日 下午7:01:04
 * </pre>
 */
public class MyAssetGalleryFlowItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name = null;

    private double amount = 0;

    private String detail = null;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
