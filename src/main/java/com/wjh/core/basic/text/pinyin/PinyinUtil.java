package com.wjh.core.basic.text.pinyin;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 汉语拼音工具
 */
public class PinyinUtil {
    // {中:zhong, 好:hao, ...}
    static Map<String, String> pyMap;

    static {
        try {
            pyMap = getPyMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将汉字和拼音的对应关系从文件读入内存
     */
    public static Map<String, String> getPyMap() throws Exception {
        Map<String, String> map = new HashMap<>();
        String chinesePinyinMapFilePath = "./src/main/java/com/wjh/core/basic/text/pinyin/py.txt";
        FileInputStream fileInputStream = new FileInputStream(chinesePinyinMapFilePath);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        String s = new String(bytes);
        String[] pys = s.split("\n");
        for (String py : pys) {
            String[] split = py.split(" ");
            String chineseCharacter = split[0];
            String pinyin = split[1];
            map.put(chineseCharacter, pinyin.trim());// 每行最后有换行
        }
        return map;
    }

    /**
     * 获取汉字的拼音
     */
    public static String getChineseCharacterPinyin(Character chineseCharacter) {
        return pyMap.get(String.valueOf(chineseCharacter));
    }

    /**
     * 获取一句汉语的拼音
     * 例如 输入：今天下雪，输出：jin tian xia xue
     */
    public static String getChineseSentencePinyin(String chineseSentence) {
        String pinyin = "";
        for (int i = 0; i < chineseSentence.length(); i++) {
            pinyin += getChineseCharacterPinyin(chineseSentence.charAt(i)) + " ";
        }
        return pinyin;
    }

    /**
     * 获取汉字拼音的首字母
     * 例如 输入：学，输出：x
     */
    public static Character getChineseCharacterPinyinInitial(Character chineseCharacter) {
        return getChineseCharacterPinyin(chineseCharacter).charAt(0);
    }

    /**
     * 获取一句汉语首字母
     * 例如 输入：王小米，输出：wxm
     */
    public static String getChineseSentencePinyinInitial(String chineseSentence) {
        String pinyinInitial = "";
        for (int i = 0; i < chineseSentence.length(); i++) {
            pinyinInitial += getChineseCharacterPinyinInitial(chineseSentence.charAt(i));
        }
        return pinyinInitial;
    }

    public static void main(String[] args) {
        System.out.println(getChineseSentencePinyin("汪简化"));
        System.out.println(getChineseCharacterPinyinInitial('学'));
        System.out.println(getChineseSentencePinyinInitial("王小米"));

        HashMap hashMap = new HashMap();
        System.out.println(hashMap.get("dd") == null);
    }
}
