package com.wjh.encode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Md5UtilTest {
    private String str = "ius314";
    private String md5Str = "e088bdc3ec7ecd2158e3a84e71d96c2e";
    private String md5ShortStr = "ec7ecd2158e3a84e";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getMD5() {
        String md5 = Md5Util.getMD5(str);
        Assert.assertEquals(md5, md5Str);
    }

    @Test
    public void getShortMD5() {
        String md5 = Md5Util.getShortMD5(str);
        Assert.assertEquals(md5, md5ShortStr);
    }
}
