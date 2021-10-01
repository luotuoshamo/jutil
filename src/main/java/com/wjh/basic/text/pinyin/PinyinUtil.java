package com.wjh.basic.text.pinyin;

import com.wjh.basic.text.CharacterUtil;
import com.wjh.basic.text.StringUtil;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 汉语拼音工具
 */
public class PinyinUtil {
    // {中:zhong, 好:hao, ...}
    private static Map<String, String> pyMap;

    static {
        try {
            pyMap = initPyMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> geyPyMap() {
        return pyMap;
    }

    /**
     * 将汉字和拼音的对应关系从文件读入内存
     */
    public static Map<String, String> initPyMap() throws Exception {
        Map<String, String> map = new HashMap<>();
        String chinesePinyinMapFilePath = "./src/main/java/com/wjh/basic/text/pinyin/py.txt";
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
     * 最重要的，其它方法都直接或间接依赖他
     *
     * @return 非汉字字符，则原样返回
     */
    public static String getChineseCharacterPinyin(Character chineseCharacter) {
        String c = String.valueOf(chineseCharacter);
        if (CharacterUtil.isNotChineseCharacter(chineseCharacter)) return c;
        if (!pyMap.containsKey(c)) return c;// TODO log it 表中没有收集的汉字
        return pyMap.get(c);
    }

    /**
     * 获取一句汉语的拼音
     * 例如 输入：今天下雪，输出：jin tian xia xue
     */
    public static String getChineseSentencePinyin(String chineseSentence) {
        String pinyin = "";
        for (int i = 0; i < chineseSentence.length(); i++) {
            pinyin += getChineseCharacterPinyin(chineseSentence.charAt(i)) + CharacterUtil.NORMAL_SPACE;
        }
        return pinyin.substring(0, pinyin.length() - 1);
    }

    /**
     * 获取汉字拼音的首字母
     * 例如 输入：学，输出：x
     */
    public static String getChineseCharacterPinyinInitial(Character chineseCharacter) {
        String chineseCharacterPinyin = getChineseCharacterPinyin(chineseCharacter);
        return StringUtil.isBlank(chineseCharacterPinyin) ? "" : chineseCharacterPinyin.charAt(0) + "";
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
}
