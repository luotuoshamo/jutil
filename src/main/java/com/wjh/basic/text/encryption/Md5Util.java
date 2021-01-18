package com.wjh.basic.text.encryption;

import com.wjh.basic.text.StringUtil;
import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;


public class Md5Util {
    /**
     * md5编码
     * https://www.bbsmax.com/A/Gkz1nmrgJR/
     */
    public static String encode(String s) {
        if (StringUtil.isBlank(s)) return null;
        try {

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] md5ByteArray = messageDigest.digest(s.getBytes("UTF-8"));

            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getMD5(String str)  {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串
            // 。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；
            // 得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws Exception{
       System.out.println(getMD5("Wjhd1604"));
        //System.out.println(encode("1"));
        String ss = new BASE64Encoder().encode(getMD5("Wjhd1604").getBytes());
        System.out.println(ss);
    }
}
