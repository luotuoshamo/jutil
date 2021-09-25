package com.wjh.basic.text;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterUtilTest {
    @Test
    public void isChineseCharacter() {
        boolean b1 = CharacterUtil.isChineseCharacter('张');
        Assert.assertTrue(b1);

        boolean b2 = CharacterUtil.isChineseCharacter('c');
        Assert.assertFalse(b2);
    }
}