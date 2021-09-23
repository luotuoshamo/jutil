package com.wjh.encode;

import com.wjh.basic.text.StringUtil;

import java.math.BigInteger;
import java.security.MessageDigest;


public class Md5Util {
    /**
     * md5编码
     *
     * @return 32位的16进制字符（即Md5编码）
     */
    public static String encode(String s) throws Exception {
        if (StringUtil.isBlank(s)) return null;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(s.getBytes());
        // digest长度为16，本质是个整数
        byte[] digest = md.digest();
        return new BigInteger(1, digest).toString(16);
    }

    /**
     * 若干次MD5编码
     */
    public static String encode(String s, int times) throws Exception {
        if (StringUtil.isBlank(s)) return null;
        String res = s;
        for (int i = 0; i < times; i++) {
            res = encode(res);
        }
        return res;
    }
}
