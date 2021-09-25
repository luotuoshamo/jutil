package com.wjh.basic.text;

public class CharacterUtil {
    // 普通英文空格
    public static final char SPACE = 32;

    /**
     * 是否是汉字字符
     */
    public static boolean isChineseCharacter(Character c) {
        String s = String.valueOf(c);
        if (StringUtil.isBlank(s)) return false;
        String reg = "^[\\u4e00-\\u9fa5]+$";
        return s.matches(reg);
    }

    public static boolean isNotChineseCharacter(Character c) {
        return !isChineseCharacter(c);
    }

    /**
     * 是否是数字字符
     */
    public static boolean isNumberCharacter(Character c) {
        String s = String.valueOf(c);
        if (StringUtil.isBlank(s)) return false;
        String reg = "^[0-9]+$";
        return s.matches(reg);
    }
}
