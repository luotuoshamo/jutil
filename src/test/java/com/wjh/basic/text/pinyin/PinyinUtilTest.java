package com.wjh.basic.text.pinyin;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PinyinUtilTest {

    @Before
    public void setUp() throws Exception {
        PinyinUtil.initPyMap();
        //System.out.println(PinyinUtil.geyPyMap());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getChineseCharacterPinyin() {
        String chineseCharacterPinyin = PinyinUtil.getChineseCharacterPinyin('张');
        Assert.assertEquals(chineseCharacterPinyin, "zhang");
        Assert.assertEquals(PinyinUtil.getChineseCharacterPinyin('c'), "c");
    }

    @Test
    public void getChineseSentencePinyin() {
        String chineseSentencePinyin = PinyinUtil.getChineseSentencePinyin("今天下雪，爸爸");
        Assert.assertEquals( "jin tian xia xue ， ba ba", chineseSentencePinyin);
    }

    @Test
    public void getChineseCharacterPinyinInitial() {
        String chineseCharacterPinyinInitial = PinyinUtil.getChineseCharacterPinyinInitial('张');
        Assert.assertEquals(chineseCharacterPinyinInitial, "z");
    }

    @Test
    public void getChineseSentencePinyinInitial() {
        String chineseSentencePinyinInitial = PinyinUtil.getChineseSentencePinyinInitial("今天下雪，爸爸");
        Assert.assertEquals("jtxx，bb", chineseSentencePinyinInitial);
    }
}