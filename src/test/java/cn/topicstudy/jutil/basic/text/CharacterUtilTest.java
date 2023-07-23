package cn.topicstudy.jutil.basic.text;

import org.junit.Assert;
import org.junit.Test;

public class CharacterUtilTest {
    @Test
    public void isChineseCharacter() {
        Assert.assertTrue(CharacterUtil.isChineseCharacter('张'));
        Assert.assertFalse(CharacterUtil.isChineseCharacter('c'));
    }

    @Test
    public void isNumberCharacter() {
        Assert.assertFalse(CharacterUtil.isNumberCharacter(null));
        Assert.assertTrue(CharacterUtil.isNumberCharacter('5'));
        Assert.assertFalse(CharacterUtil.isNumberCharacter('a'));
    }

    @Test
    public void isLowerCaseLetter() {
        Assert.assertTrue(CharacterUtil.isLowerCaseLetter('a'));
        Assert.assertFalse(CharacterUtil.isLowerCaseLetter('A'));
    }

    @Test
    public void isUpperCaseLetter() {
        Assert.assertTrue(CharacterUtil.isUpperCaseLetter('A'));
        Assert.assertFalse(CharacterUtil.isUpperCaseLetter('a'));
    }

    @Test
    public void isNormalSpace() {
        Assert.assertTrue(CharacterUtil.isNormalSpace(' '));
    }

    @Test
    public void isNbspSpace() {
        char c = 160;
        Assert.assertTrue(CharacterUtil.isNbspSpace(c));
    }

    @Test
    public void isSpace() {
    }
}
