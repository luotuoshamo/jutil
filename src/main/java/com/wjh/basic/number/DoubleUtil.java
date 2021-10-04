package com.wjh.basic.number;


import com.wjh.basic.text.StringUtil;

import java.math.BigDecimal;

public class DoubleUtil {
    /**
     * 四舍五入
     *
     * @param retainDecimalCnt 要保留的小数位数
     */
    public static String halfAdjust(Double d, Integer retainDecimalCnt) {
        if (d == null || d.equals(0)) return null;
        return String.format("%." + retainDecimalCnt + "f", d);
    }

    /**
     * double转成百分数
     */
    public static String percentage(Double d, Integer retainDecimalCnt) {
        if (d == null) return null;
        // d*100可能导致小数位数改变，如0.0251*100=2.5100000000000002
        // return d * 100 + "%";

        // fix:
        return halfAdjust(d * 100, retainDecimalCnt) + "%";
    }

}
