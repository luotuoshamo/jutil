package cn.topicstudy.encode;

import cn.topicstudy.basic.text.StringUtil;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    /**
     * 返回Md5编码结果
     *
     * @return 例如 e088bdc3ec7ecd2158e3a84e71d96c2e  共32个字符，
     * 16个字符的MD5就是将头8个和尾8个字符去掉，即ec7ecd2158e3a84e
     */
    public static String getMD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            byte[] digest = md.digest();// 摘要，16bytes的数组
            System.out.println(md.digest().length);
            return new BigInteger(1, digest).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 指定次数的MD5编码
     */
    public static String getMD5(String s, int times) {
        if (StringUtil.isBlank(s)) return null;
        String res = s;
        for (int i = 0; i < times; i++) res = getMD5(res);
        return res;
    }
}
