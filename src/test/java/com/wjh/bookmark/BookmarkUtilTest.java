package com.wjh.bookmark;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class BookmarkUtilTest {
    private final File chromeBookmarkFile = new File("src/test/java/com/wjh/bookmark/bookmarks_10_7_21-chrome.html");

    public void setUp() throws Exception {

    }

    public void tearDown() throws Exception {
    }

    @Test
    public void testParse() throws IOException {
        Bookmark bookmark = BookmarkUtil.parse(chromeBookmarkFile);
        System.out.println(bookmark);
        Assert.assertNotNull(bookmark);
        Assert.assertEquals(bookmark.getPages().size(), 2);
        Assert.assertEquals(bookmark.getFolders().size(), 2);
    }

    /**
     * 竖线导致失败
     */
    //@Test
    public void testStr() {
        String s = "<DL><p>                        <DT><A HREF=\"https://www.hua.com\" ADD_DATE=\"1633581535\">鲜花网|花礼网-鲜花礼品网,领先鲜花速递网站,网上订花送花上门,同城鲜花快递网上花店</A>            <DT><A HREF=\"https://uland.taobao.com/sem/tbsearch\" ADD_DATE=\"1633579211\">热卖PC搜索</A>            <DT><A HREF=\"https://www.pinduoduo.com/\" ADD_DATE=\"1633579265\">拼多多 新电商开创者</A>        </DL><p>";
        String r = "<DT><A HREF=\"https://www.hua.com\" ADD_DATE=\"1633581535\">鲜花网|花礼网-鲜花礼品网,领先鲜花速递网站,网上订花送花上门,同城鲜花快递网上花店</A>";
        s = s.replaceFirst(r, "");
        System.out.println(s);
    }

}