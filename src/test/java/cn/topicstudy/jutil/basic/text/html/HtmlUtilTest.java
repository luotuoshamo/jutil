package cn.topicstudy.jutil.basic.text.html;

import junit.framework.TestCase;

public class HtmlUtilTest extends TestCase {
    private String singleLayerHtmlTag = "<A HREF=\"https://www.zhihu.com/question/336108123\" ICON=\"data:image/png;ba..”>知乎</A>";

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testParseSingleLayerHtmlTag() {
        SingleLayerHtmlTag htmlTag = HtmlUtil.parseSingleLayerHtmlTag(singleLayerHtmlTag, "A", true);
        System.out.println(htmlTag);
    }
}
