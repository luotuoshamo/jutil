package com.wjh.basic.text;

import java.io.UnsupportedEncodingException;
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
        return s == null || deepTrim(s).isEmpty();
    }

    public static boolean isNotBlank(String s) {
        return !isBlank(s);
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
     * String.replace就是替换所有
     */
    @Deprecated
    public static String replaceAll(String s, String target, String replacement) {
        if (isBlank(s)) return s;
        /* if (target == null) return s;
        while (true) {
            if (s.indexOf(target) == -1) break;
            s = s.replace(target, replacement);
        }
        return s;*/
        return s.replace(target, replacement);
    }

    /**
     * 判断s中是否包含contain,忽略大小写
     */
    public static boolean containsIgnoreCase(String s, String contain) {
        if (isBlank(s) || isBlank(contain)) return false;
        return s.toLowerCase().contains(contain.toLowerCase());
    }

    /**
     * 去掉最后一个，jdk有String.replaceFirst但五String.replaceLast
     * 例如s=12cd67cd01cd,replacement=cd
     */
    public static String replaceLast(String s, String target, String replacement) {
        if (isBlank(s)) return s;
        if (replacement == null) return s;

        String r = reverse(s).replaceFirst(reverse(target), reverse(replacement));
        return reverse(r);
    }

    /**
     * 倒置字符串
     *
     * @param s
     * @return 新字符串，不改变原来的字符串
     */
    public static String reverse(String s) {
        if (isBlank(s) || s.length() == 1) return s;
        String reversedStr = "";
        for (int i = s.length() - 1; i >= 0; i--) reversedStr += s.charAt(i);
        return reversedStr;
    }

    /**
     * byte[] 是01串，无编码
     */
    public static byte[] strToBytes(String s, String charset) {
        if (isBlank(s)) {
            return null;
        }

        try {
            return s.getBytes(charset);
        } catch (Exception e) {
            return null;
        }
    }

    public static String bytesToStr(byte[] bytes, String charset) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }

        try {
            return new String(bytes, charset);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
