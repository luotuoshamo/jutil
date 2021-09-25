package com.wjh.basic.text;

public class CharacterUtil {
    // 普通英文空格
    public static final Character NORMAL_SPACE = 32;
    public static final Character NBSP_SPACE = 160;

    public static boolean isNormalSpace(Character c) {
        return NORMAL_SPACE.equals(c);
    }

    public static boolean isNbspSpace(Character c) {
        return NBSP_SPACE.equals(c);
    }

    public static boolean isSpace(Character c) {
        return isNormalSpace(c) || isNbspSpace(c);
    }

    public static boolean isNotSpace(Character c) {
        return !isSpace(c);
    }

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

    public static boolean isLowerCaseLetter(Character c) {
        String s = String.valueOf(c);
        if (StringUtil.isBlank(s)) return false;
        String reg = "^[a-z]+$";
        return s.matches(reg);
    }

    public static boolean isUpperCaseLetter(Character c) {
        String s = String.valueOf(c);
        if (StringUtil.isBlank(s)) return false;
        String reg = "^[A-Z]+$";
        return s.matches(reg);
    }
}
