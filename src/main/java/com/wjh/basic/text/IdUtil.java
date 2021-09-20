package com.wjh.basic.text;

import java.util.Random;
import java.util.UUID;

/**
 * 获取id
 * UUID、雪花算法
 */
public class IdUtil {
    /**
     * 获取全球唯一的字符串
     * 生成2个相同的字符串的概率是62^length
     *
     * @param length 随机字符串的长度 建议取8
     */
    public static String uniqueString(int length) {
        String s = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(StringUtil.DIGITAL_AND_LETTER.length());
            s += StringUtil.DIGITAL_AND_LETTER.charAt(randomIndex);
        }
        return s;
    }

    /**
     * uuid
     * @return 例如 0838dad0-1fd3-4236-b911-27e4f2b4040e
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    /**
     * 无横线的uuid
     * @return 例如 dc962d91e9954b499c5df68a72f4aecf
     */
    public static String uuidWithoutLine() {
        return uuid().replaceAll("-", "");
    }
}
