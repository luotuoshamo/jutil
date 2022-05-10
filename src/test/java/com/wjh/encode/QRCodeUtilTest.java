package com.wjh.encode;

import junit.framework.TestCase;

public class QRCodeUtilTest extends TestCase {

    public void testCreateQRCode() {
        QRCodeUtil.createQRCode("http://topicstudy.cn",500,500);
    }

    public void testGetBase64QrCode() {
    }
}
