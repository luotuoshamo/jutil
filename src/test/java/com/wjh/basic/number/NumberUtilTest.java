package com.wjh.basic.number;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

public class NumberUtilTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testChineseUppercaseMap() {
        assertEquals("捌", NumberUtil.chineseUppercaseMap().get("8"));
    }

    /**
     * unit test delicious
     */
    public void testGetUpperCaseMoney() {
        assertEquals("--", NumberUtil.getMoneyUppercase(""));
        assertEquals("人民币壹仟贰佰叁拾肆亿伍仟陆佰柒拾捌万玖仟壹佰贰拾叁圆壹角贰分", NumberUtil.getMoneyUppercase("123456789123.12"));
        assertEquals("人民币零圆壹角贰分", NumberUtil.getMoneyUppercase("0.12"));
        assertEquals("人民币壹仟肆佰零玖圆伍角", NumberUtil.getMoneyUppercase("1409.50"));
        assertEquals("人民币陆仟零柒圆壹角肆分", NumberUtil.getMoneyUppercase("6007.14"));
        assertEquals("人民币壹拾万柒仟圆伍角叁分", NumberUtil.getMoneyUppercase("107000.53"));
        assertEquals("人民币壹万陆仟肆佰零玖圆零贰分", NumberUtil.getMoneyUppercase("16409.02"));
        assertEquals("人民币叁佰贰拾伍圆零肆分", NumberUtil.getMoneyUppercase("325.04"));
    }
}