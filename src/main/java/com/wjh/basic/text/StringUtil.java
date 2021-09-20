package com.wjh.basic.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 字符串工具类
 */
public class StringUtil {
    public static final String DIGITAL = "0123456789";
    public static final String LOWER_CASE_LETTER = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPER_CASE_LETTER = LOWER_CASE_LETTER.toUpperCase();
    public static final String DIGITAL_AND_LETTER = DIGITAL + LOWER_CASE_LETTER + UPPER_CASE_LETTER;

    /**
     * 判断字符串是否为空
     * ""        true
     * "   "     true
     * "a"       false
     */
    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    /**
     * 判断字符串是否是数值
     * "100"        true
     * "100.01"     true
     * "100."       true
     * "100a"       false
     */
    public static boolean isNumber(String s) {
        if (isBlank(s)) return false;

        // 小数
        if (!s.contains(".")) {
            try {// 整数
                Integer.parseInt(s);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            try {
                Double.parseDouble(s);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
}
