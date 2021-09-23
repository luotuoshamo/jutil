package com.wjh;

import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class T2 {
    @Test
    public void f() throws Exception {
        String s = "Wjhd1604";
        byte[] s_md5 = MessageDigest.getInstance("md5").digest(s.getBytes("UTF-8"));
        byte[] s_md5_2 = MessageDigest.getInstance("md5").digest(s_md5);
        System.out.println(new String(s_md5));
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = base64Encoder.encode(s_md5_2);
        System.out.println(encode);
    }

    public static String getMD5Str(String str) {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest  = md5.digest(str.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        return md5Str;
    }

    @Test
    public void ttt(){
        String[] s = "sohu.com".split("\\.");
        System.out.println(s[0]);
    }
}
