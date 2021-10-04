package com.wjh.basic.number;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DoubleUtilTest extends TestCase {
    private Double d = 3.1415926;

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }


    public void testHalfAdjust() {
        String s = DoubleUtil.halfAdjust(d, 3);
        Assert.assertEquals("3.142", s);
    }

    public void testPercentage() {
        Assert.assertEquals("314.15926%", DoubleUtil.percentage(d,5));

        Long a = 3917365248L;
        Long b = 4018077696L;
        double v = 1 - a.doubleValue() / b.doubleValue();
        String s = DoubleUtil.halfAdjust(v, 4);
        System.out.println(Double.parseDouble(s));
        System.out.println(DoubleUtil.percentage(Double.parseDouble(s),2));

    }
}