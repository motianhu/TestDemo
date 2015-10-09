/**
 * Title: MoneyUtil.java
 * Description: 
 * Copyright: Copyright (c) 2013-2015 luoxudong.com
 * Company: 个人
 * Author: 罗旭东 (hi@luoxudong.com)
 * Date: 2015年8月11日 下午5:01:08
 * Version: 1.0
 */
package com.smona.app.demo.evendemo;

import java.text.DecimalFormat;

/**
 * <pre>
 * ClassName: MoneyUtil
 * Description:金额换算工具类
 * Create by: 罗旭东
 * Date: 2015年8月11日 下午5:01:08
 * </pre>
 */
public class MoneyUtil {
    /**
     * 保留小数点2位
     * 
     * @param val
     */
    public static String formatMoney(double val) {
        return formatMoney(val, 2);
    }

    /**
     * 保留小数点n位,小数点位为0时去掉
     * 
     * @param val
     *            金额
     * @param scale
     *            保留小数点位数
     */
    public static String formatMoney(double val, int scale) {
        String pattern = "#.";
        for (int nIndex = 0; nIndex < scale; nIndex++) {
            pattern += "#";
        }

        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String ret = decimalFormat.format(val);

        if (ret.indexOf(".") >= 0) {
            for (int nIndex = ret.indexOf("."); nIndex < ret.length(); nIndex++) {
                if (ret.charAt(nIndex) != 0) {// 小数部分不为0，有效
                    return ret;
                }
            }
        }

        // 小数部分为0，去掉0
        return String.valueOf((int) val);
    }

    /**
     * 保留小数点2位，小数位为0时保留
     * 
     * @param val
     * @return
     */
    public static String formatMoneyHold(double val) {
        return formatMoneyHold(val, 2);
    }

    /**
     * 保留小数点n位,小数点位为0时保留
     * 
     * @param val
     * @param scale
     * @return
     */
    public static String formatMoneyHold(double val, int scale) {
        String pattern = "#.";
        for (int nIndex = 0; nIndex < scale; nIndex++) {
            pattern += "0";
        }

        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String ret = decimalFormat.format(val);

        if (ret.charAt(0) == '.') {
            ret = "0" + ret;
        }
        return ret;
    }

    /***
     * 千分位金额格式化
     * 
     * @param val
     * @return
     */
    public static String formatMoneyThousHold(double val) {
        return formatMoneyThousHold(val, 2);
    }

    /**
     * 带千分位，保留两位小数点
     * 
     * @param val
     * @param scale
     * @return
     */
    public static String formatMoneyThousHold(double val, int scale) {
        String pattern = "###,###.";
        for (int nIndex = 0; nIndex < scale; nIndex++) {
            pattern += "0";
        }

        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String ret = decimalFormat.format(val);

        if (ret.charAt(0) == '.') {
            ret = "0" + ret;
        }
        return ret;
    }
}
