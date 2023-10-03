package cn.topicstudy.jutil.basic.text;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isBlank() {
        Assert.assertFalse(StringUtil.isBlank("null"));
        Assert.assertTrue(StringUtil.isBlank(""));
        Assert.assertTrue(StringUtil.isBlank(String.valueOf(CharacterUtil.NBSP_SPACE)));
    }

    @Test
    public void deepTrim() {
        String nbsp = String.valueOf(CharacterUtil.NBSP_SPACE);
        String s = nbsp + nbsp + nbsp;
        assertEquals(StringUtil.deepTrim(s).length(), 0);
    }

    @Test
    public void isNumber() {
        Assert.assertTrue(StringUtil.isNumber("1"));
        Assert.assertTrue(StringUtil.isNumber("1.2"));
        Assert.assertTrue(StringUtil.isNumber(".2"));
        Assert.assertFalse(StringUtil.isNumber("aa"));
    }

    @Test
    public void isNotBlank() {
        Assert.assertTrue(StringUtil.isNotBlank("a"));
        Assert.assertFalse(StringUtil.isNotBlank("   "));
    }

    @Test
    public void containsIgnoreCase() {
        boolean b = StringUtil.containsIgnoreCase("ABCDeFG", "cdE");
        Assert.assertTrue(b);
    }

    @Test
    public void replaceLast() {
        String s = "12cd34cd56cd78cd00";
        String s2 = StringUtil.replaceLast(s, "cd", "xx");
        Assert.assertEquals("12cd34cd56cd78xx00", s2);
    }

    @Test
    public void reverse() {
        assertEquals("CBA", StringUtil.reverse("ABC"));
    }

    public void testTestIsBlank() {
    }

    public void testTestIsNotBlank() {
    }

    public void testTestDeepTrim() {
    }

    public void testTestIsNumber() {
    }

    public void testReplaceAll() {
    }

    public void testTestContainsIgnoreCase() {
    }

    public void testTestReplaceLast() {
    }

    public void testTestReverse() {
    }

    public void testStrToBytes() {
    }

    public void testBytesToStr() {
    }

    public void testObjectToStrQuiet() {
    }
}
