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
    public static final String DIGITAL_LETTER = DIGITAL + LOWER_CASE_LETTER + UPPER_CASE_LETTER;

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
        if (isBlank(s)) {
            return false;
        }
        //是小数
        if (!s.contains(".")) {
            try {
                Integer.parseInt(s);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {//非小数
            try {
                Double.parseDouble(s);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    /**
     * 获取全球唯一的字符串
     * 生成2个相同的字符串的概率是62^length
     *
     * @param length 随机字符串的长度 建议取8
     */
    public static String getUniqueString(int length) {
        String s = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(DIGITAL_LETTER.length());
            s += DIGITAL_LETTER.charAt(randomIndex);
        }
        return s;
    }

    /**
     * 获取全球唯一的字符串
     * 生成2个相同的字符串的概率是62^length
     */
    public static String getUniqueString() {
        return getUniqueString(8);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // 测试破解难度
        for (int i = 0; i < 1000_0000; i++) {
            String uniqueString = getUniqueString(8);
            if (list.contains(uniqueString)) {
                System.out.println("conflict");
            }
            list.add(uniqueString);
        }
    }
}
