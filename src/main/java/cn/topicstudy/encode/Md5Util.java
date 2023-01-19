package cn.topicstudy.encode;

import cn.topicstudy.basic.file.FileUtil;
import cn.topicstudy.basic.text.StringUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * message digest 信息摘要
 * 可以产生出一个128位（16字节）的散列值（hash value），用于确保信息传输完整一致
 * 通常使用16进制串展示，长度128/4=32,有时为了缩短长度将头8个和尾8个字符去掉，长度就变成16
 */
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
            // 16bytes
            byte[] digest = md.digest();
            return new BigInteger(1, digest).toString(16);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String getMD5(byte[] bytes) {
        if (bytes == null || bytes.length == 0) return null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(bytes);
            byte[] digest = md.digest();
            return new BigInteger(1, digest).toString(16);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getShortMD5(String s) {
        return longToShort(getMD5(s));
    }

    public static String getShortMD5(byte[] bytes) {
        return longToShort(getMD5(bytes));
    }

    private static String longToShort(String md5) {
        return StringUtil.isBlank(md5) ? null : md5.substring(8, 24);
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

    public static String getFileMD5(InputStream is) {
        if (is == null) {
            return null;
        }

        byte[] bytes = FileUtil.inputStreamToByteArray(is);
        return getMD5(bytes);
    }
}
