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
     * "   "     true  这里是nbsp空格，普通空格的编码是32，nbsp空格的编码是160
     * "a"       false
     * "null"    true    String.valueOf(obj)如果obj是null就转成“null”
     */
    public static boolean isBlank(String s) {
        return s == null || deepTrim(s).isEmpty() || "null".equalsIgnoreCase(s);
    }

    /**
     * String.trim只能去掉编码是32的空格，去不掉编码是160的nbsp空格
     */
    public static String deepTrim(String s) {
        if (s == null) return null;
        String newStr = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (CharacterUtil.isNotSpace(c)) newStr += c;
        }
        return newStr;
    }

    /**
     * 判断字符串是否是数值
     * "100"        true
     * "100.01"     true
     * "100."       true
     * "100a"       false
     * ".2"         true
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

    /**
     * 功能等价于String.replaceAll
     * 但是"abc${name}123${name}".reolaceAll("${name}","wjh") 编译报错
     */
    public static String replaceAll(String s, String target, String replacement) {
        if (isBlank(s)) return s;
        if (target == null) return s;
        while (true) {
            if (s.indexOf(target) == -1) break;
            s = s.replace(target, replacement);
        }
        return s;
    }

    /**
     * 判断s中是否包含contain,忽略大小写
     */
    public static boolean constainsIgnoreCase(String s, String contain) {
        if (isBlank(s) || isBlank(contain)) return false;
        return s.toLowerCase().contains(contain.toLowerCase());
    }
}
